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

public final class ActivityEditProjectBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ShapeableImageView ImageEditProjectBackArrow;

  @NonNull
  public final ShapeableImageView ImageEditProjectSaveIcon;

  @NonNull
  public final RelativeLayout LBLCreateProjectCommentsLine;

  @NonNull
  public final MaterialTextView LBLCreateProjectDescription;

  @NonNull
  public final MaterialTextView LBLEditProjectTeam;

  @NonNull
  public final LinearLayout LBLProjectViewDescriptionContent;

  @NonNull
  public final RelativeLayout LBLTASKDescriptionLine;

  @NonNull
  public final EditText editTextEditProjectDescription;

  @NonNull
  public final EditText editTextEditProjectProjectName;

  @NonNull
  public final EditText editTextEditProjectTeamContent;

  @NonNull
  public final Spinner spinnerEditProjectComplexity;

  @NonNull
  public final Spinner spinnerEditProjectEmergency;

  @NonNull
  public final Spinner spinnerEditProjectSize;

  private ActivityEditProjectBinding(@NonNull RelativeLayout rootView,
      @NonNull ShapeableImageView ImageEditProjectBackArrow,
      @NonNull ShapeableImageView ImageEditProjectSaveIcon,
      @NonNull RelativeLayout LBLCreateProjectCommentsLine,
      @NonNull MaterialTextView LBLCreateProjectDescription,
      @NonNull MaterialTextView LBLEditProjectTeam,
      @NonNull LinearLayout LBLProjectViewDescriptionContent,
      @NonNull RelativeLayout LBLTASKDescriptionLine,
      @NonNull EditText editTextEditProjectDescription,
      @NonNull EditText editTextEditProjectProjectName,
      @NonNull EditText editTextEditProjectTeamContent,
      @NonNull Spinner spinnerEditProjectComplexity, @NonNull Spinner spinnerEditProjectEmergency,
      @NonNull Spinner spinnerEditProjectSize) {
    this.rootView = rootView;
    this.ImageEditProjectBackArrow = ImageEditProjectBackArrow;
    this.ImageEditProjectSaveIcon = ImageEditProjectSaveIcon;
    this.LBLCreateProjectCommentsLine = LBLCreateProjectCommentsLine;
    this.LBLCreateProjectDescription = LBLCreateProjectDescription;
    this.LBLEditProjectTeam = LBLEditProjectTeam;
    this.LBLProjectViewDescriptionContent = LBLProjectViewDescriptionContent;
    this.LBLTASKDescriptionLine = LBLTASKDescriptionLine;
    this.editTextEditProjectDescription = editTextEditProjectDescription;
    this.editTextEditProjectProjectName = editTextEditProjectProjectName;
    this.editTextEditProjectTeamContent = editTextEditProjectTeamContent;
    this.spinnerEditProjectComplexity = spinnerEditProjectComplexity;
    this.spinnerEditProjectEmergency = spinnerEditProjectEmergency;
    this.spinnerEditProjectSize = spinnerEditProjectSize;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditProjectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditProjectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_project, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditProjectBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Image_EditProject_backArrow;
      ShapeableImageView ImageEditProjectBackArrow = ViewBindings.findChildViewById(rootView, id);
      if (ImageEditProjectBackArrow == null) {
        break missingId;
      }

      id = R.id.Image_EditProject_saveIcon;
      ShapeableImageView ImageEditProjectSaveIcon = ViewBindings.findChildViewById(rootView, id);
      if (ImageEditProjectSaveIcon == null) {
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

      id = R.id.LBL_editProject_Team;
      MaterialTextView LBLEditProjectTeam = ViewBindings.findChildViewById(rootView, id);
      if (LBLEditProjectTeam == null) {
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

      id = R.id.editText_EditProject_Description;
      EditText editTextEditProjectDescription = ViewBindings.findChildViewById(rootView, id);
      if (editTextEditProjectDescription == null) {
        break missingId;
      }

      id = R.id.editText_EditProject_ProjectName;
      EditText editTextEditProjectProjectName = ViewBindings.findChildViewById(rootView, id);
      if (editTextEditProjectProjectName == null) {
        break missingId;
      }

      id = R.id.editText_EditProject_TeamContent;
      EditText editTextEditProjectTeamContent = ViewBindings.findChildViewById(rootView, id);
      if (editTextEditProjectTeamContent == null) {
        break missingId;
      }

      id = R.id.spinner_editProject_Complexity;
      Spinner spinnerEditProjectComplexity = ViewBindings.findChildViewById(rootView, id);
      if (spinnerEditProjectComplexity == null) {
        break missingId;
      }

      id = R.id.spinner_editProject_Emergency;
      Spinner spinnerEditProjectEmergency = ViewBindings.findChildViewById(rootView, id);
      if (spinnerEditProjectEmergency == null) {
        break missingId;
      }

      id = R.id.spinner_editProject_Size;
      Spinner spinnerEditProjectSize = ViewBindings.findChildViewById(rootView, id);
      if (spinnerEditProjectSize == null) {
        break missingId;
      }

      return new ActivityEditProjectBinding((RelativeLayout) rootView, ImageEditProjectBackArrow,
          ImageEditProjectSaveIcon, LBLCreateProjectCommentsLine, LBLCreateProjectDescription,
          LBLEditProjectTeam, LBLProjectViewDescriptionContent, LBLTASKDescriptionLine,
          editTextEditProjectDescription, editTextEditProjectProjectName,
          editTextEditProjectTeamContent, spinnerEditProjectComplexity, spinnerEditProjectEmergency,
          spinnerEditProjectSize);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
