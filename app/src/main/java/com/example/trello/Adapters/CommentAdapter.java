package com.example.trello.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trello.Data.DataManager.Gender;
import com.example.trello.Interfaces.RecyclerViewInterface;
import com.example.trello.Models.Comment;
import com.example.trello.Models.User;
import com.example.trello.R;
import com.example.trello.Utils.MySP;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    private final Context context;
    private final ArrayList<Comment> comments;


    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        this.context = context;
        this.comments = comments;
        this.comments.remove(0);

    }


    @NonNull
    @Override
    public CommentAdapter.CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentHolder(LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false), comments);


    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentHolder holder, int position) {
        holder.commentText.setText(comments.get(position).getCommentText());
        holder.commentDate.setText(comments.get(position).getDate());


        holder.itemView.setTag(comments.get(position).getWriterEmail());

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String writerEmail = (String) holder.itemView.getTag();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    if (user != null && user.getEmail().equals(writerEmail)) {
                        Gender gender = user.getGender();
                        if (writerEmail.equals(FirebaseAuth.getInstance().getCurrentUser().getEmail()))
                            holder.commentWriterName.setText("You");
                        else {
                            String fullName = user.getFirstname() + " " + user.getLastname();
                            holder.commentWriterName.setText(fullName);
                        }
                        if (gender == Gender.NON_BINARY) {
                            holder.personImage.setImageResource(R.drawable.baseline_person_non_binary);
                        } else if (gender == Gender.MALE) {
                            holder.personImage.setImageResource(R.drawable.baseline_person_man);
                        } else {
                            holder.personImage.setImageResource(R.drawable.baseline_person_woman);
                        }
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class CommentHolder extends RecyclerView.ViewHolder {

        public ShapeableImageView personImage;
        public MaterialTextView commentWriterName;
        public MaterialTextView commentText;

        public MaterialTextView commentDate;


        public CommentHolder(@NonNull View itemView, final ArrayList<Comment> comments) {
            super(itemView);

            findViewsHolder();

        }

        public void findViewsHolder() {
            commentWriterName = itemView.findViewById(R.id.commentWriter);
            commentText = itemView.findViewById(R.id.commentText);
            commentDate = itemView.findViewById(R.id.commentDate);
            personImage = itemView.findViewById(R.id.personImage);
        }
    }
}
