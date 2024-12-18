package com.example.trello.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.trello.Adapters.CommentAdapter;
import com.example.trello.Models.Comment;
import com.example.trello.Models.Task;
import com.example.trello.R;
import com.example.trello.SignalGenerator;
import com.example.trello.Utils.DrawerBaseActivity;
import com.example.trello.Utils.MySP;
import com.example.trello.databinding.ActivityTaskBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends DrawerBaseActivity {

    ActivityTaskBinding activityTaskBinding;
    private MaterialTextView taskName;
    private MaterialTextView taskDescription;
    private MaterialTextView taskComplexity;
    private MaterialTextView taskSize;
    private MaterialTextView taskEmergency;
    private MaterialTextView taskTeam;

    private String taskID;
    private String projectID;
    private ShapeableImageView backArrow;
    private EditText commentText;
    private ShapeableImageView addComment;

    private RecyclerView commentsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTaskBinding = ActivityTaskBinding.inflate(getLayoutInflater());
        setContentView(activityTaskBinding.getRoot());
        allocateActivityTitle("Task");

        Intent intent = getIntent();
        if (intent != null) {
            taskID = intent.getStringExtra("taskID");
            projectID = intent.getStringExtra("projectID");
        }

        findViews();

        setTaskData();
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTasksView();
            }
        });

        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentText.getText().toString().trim();
                if (!comment.isEmpty()) {
                    addCommentToTask(comment);
                } else {
                    SignalGenerator.getInstance().toast("Comment is empty", 0);
                }
            }
        });
    }


    private void addCommentToTask(String comment) {
        DatabaseReference taskRef = FirebaseDatabase.getInstance().getReference("tasks").child(taskID);
        DatabaseReference commentsRef = taskRef.child("comments");

        commentsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    List<Comment> existingComments = new ArrayList<>();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Comment existingComment = snapshot.getValue(Comment.class);
                        if (existingComment != null) {
                            existingComments.add(existingComment);
                        }
                    }


                    Comment newComment = new Comment(FirebaseAuth.getInstance().getCurrentUser().getEmail(), commentText.getText().toString(), comment);
                    existingComments.add(newComment);


                    commentsRef.setValue(existingComments, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@NonNull DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if (databaseError == null) {
                                SignalGenerator.getInstance().toast("Comment was added successfully", 1);
                                commentText.setText("");
                            } else {
                                SignalGenerator.getInstance().toast("Failed to add comment", 1);
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void openTasksView() {
        Intent intent = new Intent(this, TasksActivity.class);
        intent.putExtra("projectID", this.projectID);
        startActivity(intent);
        finish();
    }


    private void setTaskData() {
        DatabaseReference taskRef = FirebaseDatabase.getInstance().getReference("tasks").child(taskID);
        taskRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Task task = dataSnapshot.getValue(Task.class);
                    if (task != null) {

                        taskName.setText(task.getTaskName());
                        taskDescription.setText(task.getTaskDescription());
                        taskComplexity.setText(task.getComplexityString());
                        taskEmergency.setText(task.getEmergencyString());
                        taskSize.setText(task.getSizeString());
                        List<String> team = task.getAssigned();
                        String members = "";
                        for (int i = 0; i < team.size(); i++) {
                            members += team.get(i) + "\n";
                        }
                        taskTeam.setText(members);
                        populateComments(task.getComments());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void populateComments(List<Comment> commentsList) {

        commentsRecycler.setLayoutManager(new LinearLayoutManager(TaskActivity.this));
        commentsRecycler.setAdapter(new CommentAdapter(getApplicationContext(), (ArrayList<Comment>) commentsList));
    }


    private void findViews() {
        taskName = findViewById(R.id.LBL_Task_taskName);
        taskDescription = findViewById(R.id.LBL_TaskView_taskDescription);
        taskComplexity = findViewById(R.id.LBL_TaskView_Complexity);
        taskEmergency = findViewById(R.id.LBL_TaskView_Emergency);
        taskSize = findViewById(R.id.LBL_TaskView_Size);
        taskTeam = findViewById(R.id.LBL_TaskView_Team);
        backArrow = findViewById(R.id.Image_Task_backArrow);
        addComment = findViewById(R.id.addComment);
        commentText = findViewById(R.id.commentText);
        commentsRecycler = findViewById(R.id.taskComments);
    }
}
