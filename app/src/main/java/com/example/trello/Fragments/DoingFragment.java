package com.example.trello.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.trello.Adapters.TaskAdapter;
import com.example.trello.Interfaces.RecyclerViewInterface;
import com.example.trello.Interfaces.TaskDataCallback;
import com.example.trello.Models.Task;
import com.example.trello.R;
import com.example.trello.SignalGenerator;
import com.example.trello.UI.TaskActivity;
import com.example.trello.Utils.MySP;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.trello.Data.DataManager.Status;

import java.util.ArrayList;


public class DoingFragment extends Fragment implements RecyclerViewInterface {

    private RecyclerView doingRecycler;
    private final ArrayList<Task> storedTasks = new ArrayList<>();
    private String projectID;
    private String projectManagerEmail;

    public DoingFragment() {

    }

    public DoingFragment(String projectID, String projectManagerEmail) {
        this.projectID = projectID;
        this.projectManagerEmail = projectManagerEmail;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_doing, container, false);

        doingRecycler = view.findViewById(R.id.recycler_Doing_recycler);

        if (projectID.equals("0")) {
            getAllProjectsTasks(new TaskDataCallback() {
                @Override
                public void onCallback(ArrayList<Task> tasks) {
                    doingRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    TaskAdapter adapter = new TaskAdapter(getContext(), tasks, DoingFragment.this);
                    doingRecycler.setAdapter(adapter);
                }
            });
        } else {
            getProjectTasks(projectID, new TaskDataCallback() {
                @Override
                public void onCallback(ArrayList<Task> tasks) {
                    doingRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    TaskAdapter adapter = new TaskAdapter(getContext(), tasks, DoingFragment.this);
                    doingRecycler.setAdapter(adapter);
                }
            });
        }

        return view;
    }


    private void getAllProjectsTasks(TaskDataCallback taskDataCallback) {
        DatabaseReference projectRef = FirebaseDatabase.getInstance().getReference("tasks");
        projectRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Task> tasks = new ArrayList<>();
                for (DataSnapshot projectSnapshot : dataSnapshot.getChildren()) {
                    Task task = projectSnapshot.getValue(Task.class);
                    if (task.getAssigned().contains(MySP.getInstance().getEmail()) && task.getStatus() == Status.DOING) {
                        tasks.add(task);
                        storedTasks.add(task);
                    }
                }
                taskDataCallback.onCallback(tasks);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void getProjectTasks(String projectID, TaskDataCallback taskDataCallback) {
        DatabaseReference projectRef = FirebaseDatabase.getInstance().getReference("tasks");
        projectRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Task> tasks = new ArrayList<>();
                for (DataSnapshot projectSnapshot : dataSnapshot.getChildren()) {
                    Task task = projectSnapshot.getValue(Task.class);
                    if (task.getProjectID().equals(projectID) && task.getStatus() == Status.DOING) {
                        tasks.add(task);
                        storedTasks.add(task);
                    }
                }
                taskDataCallback.onCallback(tasks);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Task task = storedTasks.get(position);
        Intent intent = new Intent(getActivity(), TaskActivity.class);
        intent.putExtra("taskID", task.getTaskID());
        intent.putExtra("projectID", task.getProjectID());
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(int position) {

        RecyclerView.ViewHolder viewHolder = doingRecycler.findViewHolderForAdapterPosition(position);
        if (viewHolder instanceof TaskAdapter.TaskHolder) {
            TaskAdapter.TaskHolder taskHolder = (TaskAdapter.TaskHolder) viewHolder;
            Button deleteButton = taskHolder.deleteButton;
            Button editButton = taskHolder.editButton;

            if (!MySP.getInstance().getEmail().equals(projectManagerEmail)) {
                deleteButton.setVisibility(View.GONE);
                editButton.setVisibility(View.GONE);
                SignalGenerator.getInstance().toast("You are not the project manager", 0);
            } else {
                if (deleteButton.getVisibility() == View.VISIBLE) {
                    deleteButton.setVisibility(View.GONE);
                    editButton.setVisibility(View.GONE);
                } else {
                    deleteButton.setVisibility(View.VISIBLE);
                    editButton.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
