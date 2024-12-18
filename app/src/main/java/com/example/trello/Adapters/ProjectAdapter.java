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
import com.example.trello.Models.Project;
import com.example.trello.R;
import com.example.trello.SignalGenerator;
import com.example.trello.UI.EditProjectActivity;
import com.example.trello.UI.HomeActivity;
import com.example.trello.UI.ProjectsActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectHolder> {


    static ArrayList<Project> projects;
    private final RecyclerViewInterface recyclerViewInterface;
    private final Context context;

    public ProjectAdapter(Context context, ArrayList<Project> projects, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        ProjectAdapter.projects = projects;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectHolder(LayoutInflater.from(context).inflate(R.layout.item_project, parent, false), recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectHolder holder, int position) {
        holder.leaderEmail = projects.get(position).getProjectManagerEmail();
        holder.projectName.setText(projects.get(position).getProjectName());
        holder.projectDescription.setText(projects.get(position).getDescription());

        holder.projectComplexity.setText(projects.get(position).getComplexityString());
        switch (projects.get(position).getComplexityString()) {
            case "Very Complex":
                holder.projectComplexity.setBackgroundResource(R.drawable.highlight_asap_vcomplex_vbig);
                break;
            case "Complex":
                holder.projectComplexity.setBackgroundResource(R.drawable.highlight_high_complex_big);
                break;
            case "Regular":
                holder.projectComplexity.setBackgroundResource(R.drawable.highlight_medium_regular_regular);
                break;
            case "Easy":
                holder.projectComplexity.setBackgroundResource(R.drawable.highlight_low_small_easy);
        }


        holder.projectEmergency.setText(projects.get(position).getEmergencyString());
        switch (projects.get(position).getEmergencyString()) {
            case "ASAP":
                holder.projectEmergency.setBackgroundResource(R.drawable.highlight_asap_vcomplex_vbig);
                break;
            case "High":
                holder.projectEmergency.setBackgroundResource(R.drawable.highlight_high_complex_big);
                break;
            case "Medium":
                holder.projectEmergency.setBackgroundResource(R.drawable.highlight_medium_regular_regular);
                break;
            case "Low":
                holder.projectEmergency.setBackgroundResource(R.drawable.highlight_low_small_easy);
        }

        holder.projectSize.setText(projects.get(position).getSizeString());

        switch (projects.get(position).getSizeString()) {
            case "Very Big":
                holder.projectSize.setBackgroundResource(R.drawable.highlight_asap_vcomplex_vbig);
                break;
            case "Big":
                holder.projectSize.setBackgroundResource(R.drawable.highlight_high_complex_big);
                break;
            case "Regular":
                holder.projectSize.setBackgroundResource(R.drawable.highlight_medium_regular_regular);
                break;
            case "Small":
                holder.projectSize.setBackgroundResource(R.drawable.highlight_low_small_easy);
        }

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");
        Query query = usersRef.orderByChild("email").equalTo(projects.get(position).getProjectManagerEmail()).limitToFirst(1);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String firstName = snapshot.child("firstname").getValue(String.class);
                    String lastName = snapshot.child("lastname").getValue(String.class);


                    holder.projectLeader.setText(firstName + " " + lastName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                System.out.println("Error: " + databaseError.getMessage());
            }
        });

    }

    @Override
    public int getItemCount() {
        return projects.size();
    }


    public static class ProjectHolder extends RecyclerView.ViewHolder {

        public MaterialTextView projectName;
        public MaterialTextView projectLeader;
        public MaterialTextView projectDescription;

        public MaterialTextView projectComplexity;
        public MaterialTextView projectSize;
        public MaterialTextView projectEmergency;
        public Button deleteButton;
        public Button editButton;
        public String leaderEmail;


        public ProjectHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            findViewsHolder();
            editButton.setVisibility(View.GONE);
            deleteButton.setVisibility(View.GONE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
                public boolean onLongClick(View view) {
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

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DeleteProduct();
                }
            });

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openEditProductActivity();
                }
            });

        }

        private void openEditProductActivity() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {

                String projectID = projects.get(position).getProjectID();
                Intent intent = new Intent(itemView.getContext(), EditProjectActivity.class);
                intent.putExtra("projectID", projectID);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                itemView.getContext().startActivity(intent);
            }
        }

        private void DeleteProduct() {


            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {

                String projectID = projects.get(position).getProjectID();


                DatabaseReference tasksRef = FirebaseDatabase.getInstance().getReference("tasks");


                Query query = tasksRef.orderByChild("projectID").equalTo(projectID);


                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot taskSnapshot : dataSnapshot.getChildren()) {
                            taskSnapshot.getRef().removeValue();

                        }
                        SignalGenerator.getInstance().toast("Project deleted successfully", 1);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                DatabaseReference projectRef = FirebaseDatabase.getInstance().getReference("projects").child(projectID);


                projectRef.removeValue();
            }

        }

        public void findViewsHolder() {
            projectName = itemView.findViewById(R.id.projectName);
            projectLeader = itemView.findViewById(R.id.projectLeader);
            projectDescription = itemView.findViewById(R.id.projectDescription);
            projectComplexity = itemView.findViewById(R.id.ProjectComplexity);
            projectSize = itemView.findViewById(R.id.ProjectSize);
            projectEmergency = itemView.findViewById(R.id.ProjectEmergency);
            editButton = itemView.findViewById(R.id.projectEditButton);
            deleteButton = itemView.findViewById(R.id.projectDeleteButton);
        }
    }
}
