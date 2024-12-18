package com.example.trello.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trello.Interfaces.RecyclerViewInterface;
import com.example.trello.Models.Task;
import com.example.trello.R;
import com.example.trello.SignalGenerator;
import com.example.trello.UI.EditTaskActivity;
import com.example.trello.Utils.MySP;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private final Context context;
    private final ArrayList<Task> tasks;

    public TaskAdapter(Context context, ArrayList<Task> tasks, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.tasks = tasks;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new TaskHolder(LayoutInflater.from(context).inflate(R.layout.item_task, parent, false), tasks, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {

        Task task = tasks.get(position);


        holder.taskName.setText(task.getTaskName());
        holder.taskDescription.setText(task.getTaskDescription());
        holder.taskComplexity.setText(task.getComplexityString());


        if (task.getAssigned().contains(MySP.getInstance().getEmail())) {
            holder.taskWarning.setVisibility(View.VISIBLE);
        } else {
            holder.taskWarning.setVisibility(View.INVISIBLE);
        }


        switch (task.getComplexityString()) {
            case "Very Complex":
                holder.taskComplexity.setBackgroundResource(R.drawable.highlight_asap_vcomplex_vbig);
                break;
            case "Complex":
                holder.taskComplexity.setBackgroundResource(R.drawable.highlight_high_complex_big);
                break;
            case "Regular":
                holder.taskComplexity.setBackgroundResource(R.drawable.highlight_medium_regular_regular);
                break;
            case "Easy":
                holder.taskComplexity.setBackgroundResource(R.drawable.highlight_low_small_easy);
                break;
        }


        holder.taskEmergency.setText(task.getEmergencyString());
        switch (task.getEmergencyString()) {
            case "ASAP":
                holder.taskEmergency.setBackgroundResource(R.drawable.highlight_asap_vcomplex_vbig);
                break;
            case "High":
                holder.taskEmergency.setBackgroundResource(R.drawable.highlight_high_complex_big);
                break;
            case "Medium":
                holder.taskEmergency.setBackgroundResource(R.drawable.highlight_medium_regular_regular);
                break;
            case "Low":
                holder.taskEmergency.setBackgroundResource(R.drawable.highlight_low_small_easy);
                break;
        }


        holder.taskSize.setText(task.getSizeString());
        switch (task.getSizeString()) {
            case "Very Big":
                holder.taskSize.setBackgroundResource(R.drawable.highlight_asap_vcomplex_vbig);
                break;
            case "Big":
                holder.taskSize.setBackgroundResource(R.drawable.highlight_high_complex_big);
                break;
            case "Regular":
                holder.taskSize.setBackgroundResource(R.drawable.highlight_medium_regular_regular);
                break;
            case "Small":
                holder.taskSize.setBackgroundResource(R.drawable.highlight_low_small_easy);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskHolder extends RecyclerView.ViewHolder {

        public MaterialTextView taskName;
        public MaterialTextView taskDescription;
        public MaterialTextView taskComplexity;
        public MaterialTextView taskSize;
        public MaterialTextView taskEmergency;
        public ShapeableImageView taskWarning;
        public Button editButton;
        public Button deleteButton;

        public TaskHolder(@NonNull View itemView, final ArrayList<Task> tasks, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);


            findViewsHolder();


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemLongClick(position);
                            return true;
                        }
                    }
                    return false;
                }
            });

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Task task = tasks.get(position);
                        String taskID = task.getTaskID();
                        String projectID = task.getProjectID();


                        Intent intent = new Intent(itemView.getContext(), EditTaskActivity.class);
                        intent.putExtra("taskID", taskID);
                        intent.putExtra("projectID", projectID);
                        itemView.getContext().startActivity(intent);
                    }
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Task task = tasks.get(position);
                        String taskID = task.getTaskID();


                        DatabaseReference taskRef = FirebaseDatabase.getInstance().getReference("tasks").child(taskID);
                        taskRef.removeValue();
                        SignalGenerator.getInstance().toast("Task deleted Successfully", 1);
                    }
                }
            });

            editButton.setVisibility(View.GONE);
            deleteButton.setVisibility(View.GONE);
        }

        public void findViewsHolder() {
            taskName = itemView.findViewById(R.id.taskName);
            taskDescription = itemView.findViewById(R.id.taskDescription);
            taskComplexity = itemView.findViewById(R.id.taskComplexity);
            taskSize = itemView.findViewById(R.id.taskSize);
            taskEmergency = itemView.findViewById(R.id.taskEmergency);
            taskWarning = itemView.findViewById(R.id.taskWarning);
            editButton = itemView.findViewById(R.id.taskEditButton);
            deleteButton = itemView.findViewById(R.id.taskDeleteButton);
        }
    }
}
