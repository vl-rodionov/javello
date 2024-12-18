// Generated by view binder compiler. Do not edit!
package com.example.trello.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.trello.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCreateProjectBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ShapeableImageView ImageCreateProjectBackArrow;

  @NonNull
  public final ShapeableImageView ImageCreateProjectSaveIcon;

  @NonNull
  public final RelativeLayout LBLCreateProjectCommentsLine;

  @NonNull
  public final MaterialTextView LBLCreateProjectDescription;

  @NonNull
  public final MaterialTextView LBLCreateProjectTeam;

  @NonNull
  public final LinearLayout LBLProjectViewDescriptionContent;

  @NonNull
  public final RelativeLayout LBLTASKDescriptionLine;

  @NonNull
  public final EditText editTextCreateProjectDescription;

  @NonNull
  public final EditText editTextCreateProjectProjectName;

  @NonNull
  public final EditText editTextCreateProjectTeamContent;

  @NonNull
  public final Spinner spinnerCreateProjectComplexity;

  @NonNull
  public final Spinner spinnerCreateProjectEmergency;

  @NonNull
  public final Spinner spinnerCreateProjectSize;

  private ActivityCreateProjectBinding(@NonNull RelativeLayout rootView,
      @NonNull ShapeableImageView ImageCreateProjectBackArrow,
      @NonNull ShapeableImageView ImageCreateProjectSaveIcon,
      @NonNull RelativeLayout LBLCreateProjectCommentsLine,
      @NonNull MaterialTextView LBLCreateProjectDescription,
      @NonNull MaterialTextView LBLCreateProjectTeam,
      @NonNull LinearLayout LBLProjectViewDescriptionContent,
      @NonNull RelativeLayout LBLTASKDescriptionLine,
      @NonNull EditText editTextCreateProjectDescription,
      @NonNull EditText editTextCreateProjectProjectName,
      @NonNull EditText editTextCreateProjectTeamContent,
      @NonNull Spinner spinnerCreateProjectComplexity,
      @NonNull Spinner spinnerCreateProjectEmergency, @NonNull Spinner spinnerCreateProjectSize) {
    this.rootView = rootView;
    this.ImageCreateProjectBackArrow = ImageCreateProjectBackArrow;
    this.ImageCreateProjectSaveIcon = ImageCreateProjectSaveIcon;
    this.LBLCreateProjectCommentsLine = LBLCreateProjectCommentsLine;
    this.LBLCreateProjectDescription = LBLCreateProjectDescription;
    this.LBLCreateProjectTeam = LBLCreateProjectTeam;
    this.LBLProjectViewDescriptionContent = LBLProjectViewDescriptionContent;
    this.LBLTASKDescriptionLine = LBLTASKDescriptionLine;
    this.editTextCreateProjectDescription = editTextCreateProjectDescription;
    this.editTextCreateProjectProjectName = editTextCreateProjectProjectName;
    this.editTextCreateProjectTeamContent = editTextCreateProjectTeamContent;
    this.spinnerCreateProjectComplexity = spinnerCreateProjectComplexity;
    this.spinnerCreateProjectEmergency = spinnerCreateProjectEmergency;
    this.spinnerCreateProjectSize = spinnerCreateProjectSize;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreateProjectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreateProjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_create_project, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreateProjectBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Image_CreateProject_backArrow;
      ShapeableImageView ImageCreateProjectBackArrow = ViewBindings.findChildViewById(rootView, id);
      if (ImageCreateProjectBackArrow == null) {
        break missingId;
      }

      id = R.id.Image_CreateProject_saveIcon;
      ShapeableImageView ImageCreateProjectSaveIcon = ViewBindings.findChildViewById(rootView, id);
      if (ImageCreateProjectSaveIcon == null) {
        break missingId;
      }

      id = R.id.LBL_CreateProject_CommentsLine;
      RelativeLayout LBLCreateProjectCommentsLine = ViewBindings.findChildViewById(rootView, id);
      if (LBLCreateProjectCommentsLine == null) {
        break missingId;
      }

      id = R.id.LBL_CreateProject_Description;
      MaterialTextView LBLCreateProjectDescription = ViewBindings.findChildViewById(rootView, id);
      if (LBLCreateProjectDescription == null) {
        break missingId;
      }

      id = R.id.LBL_CreateProject_Team;
      MaterialTextView LBLCreateProjectTeam = ViewBindings.findChildViewById(rootView, id);
      if (LBLCreateProjectTeam == null) {
        break missingId;
      }

      id = R.id.LBL_ProjectView_descriptionContent;
      LinearLayout LBLProjectViewDescriptionContent = ViewBindings.findChildViewById(rootView, id);
      if (LBLProjectViewDescriptionContent == null) {
        break missingId;
      }

      id = R.id.LBL_TASK_descriptionLine;
      RelativeLayout LBLTASKDescriptionLine = ViewBindings.findChildViewById(rootView, id);
      if (LBLTASKDescriptionLine == null) {
        break missingId;
      }

      id = R.id.editText_CreateProject_Description;
      EditText editTextCreateProjectDescription = ViewBindings.findChildViewById(rootView, id);
      if (editTextCreateProjectDescription == null) {
        break missingId;
      }

      id = R.id.editText_CreateProject_ProjectName;
      EditText editTextCreateProjectProjectName = ViewBindings.findChildViewById(rootView, id);
      if (editTextCreateProjectProjectName == null) {
        break missingId;
      }

      id = R.id.editText_CreateProject_TeamContent;
      EditText editTextCreateProjectTeamContent = ViewBindings.findChildViewById(rootView, id);
      if (editTextCreateProjectTeamContent == null) {
        break missingId;
      }

      id = R.id.spinner_CreateProject_Complexity;
      Spinner spinnerCreateProjectComplexity = ViewBindings.findChildViewById(rootView, id);
      if (spinnerCreateProjectComplexity == null) {
        break missingId;
      }

      id = R.id.spinner_CreateProject_Emergency;
      Spinner spinnerCreateProjectEmergency = ViewBindings.findChildViewById(rootView, id);
      if (spinnerCreateProjectEmergency == null) {
        break missingId;
      }

      id = R.id.spinner_CreateProject_Size;
      Spinner spinnerCreateProjectSize = ViewBindings.findChildViewById(rootView, id);
      if (spinnerCreateProjectSize == null) {
        break missingId;
      }

      return new ActivityCreateProjectBinding((RelativeLayout) rootView,
          ImageCreateProjectBackArrow, ImageCreateProjectSaveIcon, LBLCreateProjectCommentsLine,
          LBLCreateProjectDescription, LBLCreateProjectTeam, LBLProjectViewDescriptionContent,
          LBLTASKDescriptionLine, editTextCreateProjectDescription,
          editTextCreateProjectProjectName, editTextCreateProjectTeamContent,
          spinnerCreateProjectComplexity, spinnerCreateProjectEmergency, spinnerCreateProjectSize);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
