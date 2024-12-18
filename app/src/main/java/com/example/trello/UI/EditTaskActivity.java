package com.example.trello.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.trello.Models.Task;
import com.example.trello.Models.User;
import com.example.trello.R;
import com.example.trello.SignalGenerator;
import com.example.trello.Utils.DrawerBaseActivity;
import com.example.trello.databinding.ActivityEditTaskBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.trello.Data.DataManager.Emergency;
import com.example.trello.Data.DataManager.Size;
import com.example.trello.Data.DataManager.Complexity;
import com.example.trello.Data.DataManager.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EditTaskActivity extends DrawerBaseActivity {

    private final String[] COMPLEXITIES = {"Complexity", "Easy", "Regular", "Complex", "Very Complex"};
    private final String[] SIZES = {"Size", "Small", "Regular", "Big", "Very big"};
    private final String[] EMERGENCIES = {"Emergency", "Low", "Medium", "High", "ASAP"};
    private final String[] STATUSES = {"Status", "Backlog", "Doing", "Done"};
    ActivityEditTaskBinding activityEditTaskBinding;
    private ShapeableImageView backArrow;
    private ShapeableImageView saveIcon;
    private EditText taskName;
    private EditText taskDescription;
    private EditText taskTeam;
    private Spinner taskComplexity;
    private Spinner taskSize;
    private Spinner taskEmergency;
    private Spinner taskStatus;
    private final List<String> emails = new ArrayList<>();
    private String taskID;
    private String projectID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEditTaskBinding = ActivityEditTaskBinding.inflate(getLayoutInflater());
        setContentView(activityEditTaskBinding.getRoot());
        allocateActivityTitle("Edit Task");

        Intent intent = getIntent();
        if (intent != null) {
            taskID = intent.getStringExtra("taskID");
            projectID = intent.getStringExtra("projectID");
        }

        findViews();
        setSpinners();
        populateData();

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTasksView();
            }
        });

        saveIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = taskName.getText().toString();
                String description = taskDescription.getText().toString();
                String complexity = taskComplexity.getSelectedItem().toString();
                String emergency = taskEmergency.getSelectedItem().toString();
                String status = taskStatus.getSelectedItem().toString();
                String size = taskSize.getSelectedItem().toString();
                String teamString = taskTeam.getText().toString();
                emails.clear();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(description) || complexity.equals("Complexity") ||
                        emergency.equals("Emergency") || size.equals("Size") || status.equals("Status")) {
                    SignalGenerator.getInstance().toast("You need to fill all fields", 1);
                } else {
                    if (!teamString.isEmpty()) {
                        String[] emailArray = teamString.split("[ \n]+");
                        for (String email : emailArray) {
                            if (isEmailValid(email)) {
                                emails.add(email);
                            } else {
                                SignalGenerator.getInstance().toast("One of your emails is not formatted correctly", 1);
                                return;
                            }
                        }
                    }
                    editTask(name, description, complexity, emergency, size, status, emails);
                }
            }
        });
    }


    private void populateData() {
        DatabaseReference taskRef = FirebaseDatabase.getInstance().getReference("tasks").child(taskID);
        taskRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Task task = dataSnapshot.getValue(Task.class);
                    if (task != null) {
                        taskName.setText(task.getTaskName());
                        taskDescription.setText(task.getTaskDescription());
                        taskTeam.setText(TextUtils.join("\n", task.getAssigned()));

                        setSpinnerSelection(taskComplexity, task.getComplexityString(), COMPLEXITIES);
                        setSpinnerSelection(taskSize, task.getSizeString(), SIZES);
                        setSpinnerSelection(taskEmergency, task.getEmergencyString(), EMERGENCIES);
                        setSpinnerSelection(taskStatus, task.getStatusString(), STATUSES);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void setSpinnerSelection(Spinner spinner, String selectedItem, String[] items) {
        if (selectedItem != null) {
            int index = Arrays.asList(items).indexOf(selectedItem);
            if (index >= 0) {
                spinner.setSelection(index);
            }
        }
    }


    private void editTask(String name, String description, String complexity, String emergency, String size, String status, List<String> emails) {

        Complexity complex = null;
        Size siz = null;
        Emergency emerg = null;
        Status stat = null;

        switch (complexity) {
            case "Easy":
                complex = Complexity.EASY;
                break;
            case "Regular":
                complex = Complexity.REGULAR;
                break;
            case "Complex":
                complex = Complexity.COMPLEX;
                break;
            case "Very Complex":
                complex = Complexity.VERY_COMPLEX;
                break;
        }

        switch (size) {
            case "Small":
                siz = Size.SMALL;
                break;
            case "Regular":
                siz = Size.REGULAR;
                break;
            case "Big":
                siz = Size.BIG;
                break;
            case "Very big":
                siz = Size.VERY_BIG;
                break;
        }

        switch (emergency) {
            case "Low":
                emerg = Emergency.LOW;
                break;
            case "Medium":
                emerg = Emergency.MEDIUM;
                break;
            case "High":
                emerg = Emergency.HIGH;
                break;
            case "ASAP":
                emerg = Emergency.ASAP;
                break;
        }

        switch (status) {
            case "Backlog":
                stat = Status.BACKLOG;
                break;
            case "Doing":
                stat = Status.DOING;
                break;
            case "Done":
                stat = Status.DONE;
                break;
        }

        Task task = new Task(name, description, emails, complex, siz, emerg, stat, projectID);

        DatabaseReference projectRef = FirebaseDatabase.getInstance().getReference("tasks").child(taskID);
        projectRef.child("taskName").setValue(task.getTaskName());
        projectRef.child("description").setValue(task.getTaskDescription());
        projectRef.child("taskDescription").setValue(task.getTaskDescription());
        projectRef.child("assigned").setValue(task.getAssigned());
        projectRef.child("complexityString").setValue(task.getComplexityString());
        projectRef.child("complexity").setValue(task.getComplexity());
        projectRef.child("sizeString").setValue(task.getSizeString());
        projectRef.child("size").setValue(task.getSize());
        projectRef.child("emergencyString").setValue(task.getEmergencyString());
        projectRef.child("emergency").setValue(task.getEmergency());
        projectRef.child("status").setValue(task.getStatus());
        projectRef.child("statusString").setValue(task.getStatusString());

        SignalGenerator.getInstance().toast("Task updated successfully", 1);
        openTasksView();
    }


    private void openTasksView() {
        Intent intent = new Intent(this, TasksActivity.class);
        intent.putExtra("projectID", TasksActivity.projectID);
        startActivity(intent);
        finish();
    }


    private void setSpinners() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, COMPLEXITIES);
        taskComplexity.setAdapter(adapter);
        taskComplexity.setSelection(0);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, SIZES);
        taskSize.setAdapter(adapter);
        taskSize.setSelection(0);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, EMERGENCIES);
        taskEmergency.setAdapter(adapter);
        taskEmergency.setSelection(0);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, STATUSES);
        taskStatus.setAdapter(adapter);
        taskStatus.setSelection(0);
    }


    private boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    private void findViews() {
        taskName = findViewById(R.id.LBL_EditTask_taskName);
        taskDescription = findViewById(R.id.editText_EditTask_Description);
        taskTeam = findViewById(R.id.editText_EditTask_AssignTeam);
        taskComplexity = findViewById(R.id.spinner_EditTask_Complexity);
        taskSize = findViewById(R.id.spinner_EditTask_Size);
        taskEmergency = findViewById(R.id.spinner_EditTask_Emergency);
        backArrow = findViewById(R.id.Image_EditTask_backArrow);
        saveIcon = findViewById(R.id.Image_EditTask_saveIcon);
        taskStatus = findViewById(R.id.spinner_EditTask_Status);
    }
}
