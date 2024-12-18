// Generated by view binder compiler. Do not edit!
package com.example.trello.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.trello.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProjectsBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ShapeableImageView ImageProjectAddProject;

  @NonNull
  public final ShapeableImageView ImageProjectBackArrow;

  @NonNull
  public final MaterialTextView LBLProjectsTitle;

  @NonNull
  public final RecyclerView recyclerProjectRecycler;

  private ActivityProjectsBinding(@NonNull RelativeLayout rootView,
      @NonNull ShapeableImageView ImageProjectAddProject,
      @NonNull ShapeableImageView ImageProjectBackArrow, @NonNull MaterialTextView LBLProjectsTitle,
      @NonNull RecyclerView recyclerProjectRecycler) {
    this.rootView = rootView;
    this.ImageProjectAddProject = ImageProjectAddProject;
    this.ImageProjectBackArrow = ImageProjectBackArrow;
    this.LBLProjectsTitle = LBLProjectsTitle;
    this.recyclerProjectRecycler = recyclerProjectRecycler;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProjectsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProjectsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_projects, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProjectsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Image_Project_addProject;
      ShapeableImageView ImageProjectAddProject = ViewBindings.findChildViewById(rootView, id);
      if (ImageProjectAddProject == null) {
        break missingId;
      }

      id = R.id.Image_Project_backArrow;
      ShapeableImageView ImageProjectBackArrow = ViewBindings.findChildViewById(rootView, id);
      if (ImageProjectBackArrow == null) {
        break missingId;
      }

      id = R.id.LBL_Projects_title;
      MaterialTextView LBLProjectsTitle = ViewBindings.findChildViewById(rootView, id);
      if (LBLProjectsTitle == null) {
        break missingId;
      }

      id = R.id.recycler_Project_recycler;
      RecyclerView recyclerProjectRecycler = ViewBindings.findChildViewById(rootView, id);
      if (recyclerProjectRecycler == null) {
        break missingId;
      }

      return new ActivityProjectsBinding((RelativeLayout) rootView, ImageProjectAddProject,
          ImageProjectBackArrow, LBLProjectsTitle, recyclerProjectRecycler);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
