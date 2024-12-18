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

public final class ActivityEditTaskBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ShapeableImageView ImageEditTaskBackArrow;

  @NonNull
  public final ShapeableImageView ImageEditTaskSaveIcon;

  @NonNull
  public final LinearLayout LBLEditTaskDescriptionContent;

  @NonNull
  public final EditText LBLEditTaskTaskName;

  @NonNull
  public final RelativeLayout LBLTASKDescriptionLine;

  @NonNull
  public final RelativeLayout LBLTASKPeopleAssignedLine;

  @NonNull
  public final MaterialTextView LBLTaskDescription;

  @NonNull
  public final MaterialTextView LBLTaskPeopleAssigned;

  @NonNull
  public final EditText editTextEditTaskAssignTeam;

  @NonNull
  public final EditText editTextEditTaskDescription;

  @NonNull
  public final Spinner spinnerEditTaskComplexity;

  @NonNull
  public final Spinner spinnerEditTaskEmergency;

  @NonNull
  public final Spinner spinnerEditTaskSize;

  @NonNull
  public final Spinner spinnerEditTaskStatus;

  private ActivityEditTaskBinding(@NonNull RelativeLayout rootView,
      @NonNull ShapeableImageView ImageEditTaskBackArrow,
      @NonNull ShapeableImageView ImageEditTaskSaveIcon,
      @NonNull LinearLayout LBLEditTaskDescriptionContent, @NonNull EditText LBLEditTaskTaskName,
      @NonNull RelativeLayout LBLTASKDescriptionLine,
      @NonNull RelativeLayout LBLTASKPeopleAssignedLine,
      @NonNull MaterialTextView LBLTaskDescription, @NonNull MaterialTextView LBLTaskPeopleAssigned,
      @NonNull EditText editTextEditTaskAssignTeam, @NonNull EditText editTextEditTaskDescription,
      @NonNull Spinner spinnerEditTaskComplexity, @NonNull Spinner spinnerEditTaskEmergency,
      @NonNull Spinner spinnerEditTaskSize, @NonNull Spinner spinnerEditTaskStatus) {
    this.rootView = rootView;
    this.ImageEditTaskBackArrow = ImageEditTaskBackArrow;
    this.ImageEditTaskSaveIcon = ImageEditTaskSaveIcon;
    this.LBLEditTaskDescriptionContent = LBLEditTaskDescriptionContent;
    this.LBLEditTaskTaskName = LBLEditTaskTaskName;
    this.LBLTASKDescriptionLine = LBLTASKDescriptionLine;
    this.LBLTASKPeopleAssignedLine = LBLTASKPeopleAssignedLine;
    this.LBLTaskDescription = LBLTaskDescription;
    this.LBLTaskPeopleAssigned = LBLTaskPeopleAssigned;
    this.editTextEditTaskAssignTeam = editTextEditTaskAssignTeam;
    this.editTextEditTaskDescription = editTextEditTaskDescription;
    this.spinnerEditTaskComplexity = spinnerEditTaskComplexity;
    this.spinnerEditTaskEmergency = spinnerEditTaskEmergency;
    this.spinnerEditTaskSize = spinnerEditTaskSize;
    this.spinnerEditTaskStatus = spinnerEditTaskStatus;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditTaskBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_task, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditTaskBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Image_EditTask_backArrow;
      ShapeableImageView ImageEditTaskBackArrow = ViewBindings.findChildViewById(rootView, id);
      if (ImageEditTaskBackArrow == null) {
        break missingId;
      }

      id = R.id.Image_EditTask_saveIcon;
      ShapeableImageView ImageEditTaskSaveIcon = ViewBindings.findChildViewById(rootView, id);
      if (ImageEditTaskSaveIcon == null) {
        break missingId;
      }

      id = R.id.LBL_EditTask_descriptionContent;
      LinearLayout LBLEditTaskDescriptionContent = ViewBindings.findChildViewById(rootView, id);
      if (LBLEditTaskDescriptionContent == null) {
        break missingId;
      }

      id = R.id.LBL_EditTask_taskName;
      EditText LBLEditTaskTaskName = ViewBindings.findChildViewById(rootView, id);
      if (LBLEditTaskTaskName == null) {
        break missingId;
      }

      id = R.id.LBL_TASK_descriptionLine;
      RelativeLayout LBLTASKDescriptionLine = ViewBindings.findChildViewById(rootView, id);
      if (LBLTASKDescriptionLine == null) {
        break missingId;
      }

      id = R.id.LBL_TASK_peopleAssignedLine;
      RelativeLayout LBLTASKPeopleAssignedLine = ViewBindings.findChildViewById(rootView, id);
      if (LBLTASKPeopleAssignedLine == null) {
        break missingId;
      }

      id = R.id.LBL_Task_Description;
      MaterialTextView LBLTaskDescription = ViewBindings.findChildViewById(rootView, id);
      if (LBLTaskDescription == null) {
        break missingId;
      }

      id = R.id.LBL_Task_PeopleAssigned;
      MaterialTextView LBLTaskPeopleAssigned = ViewBindings.findChildViewById(rootView, id);
      if (LBLTaskPeopleAssigned == null) {
        break missingId;
      }

      id = R.id.editText_EditTask_AssignTeam;
      EditText editTextEditTaskAssignTeam = ViewBindings.findChildViewById(rootView, id);
      if (editTextEditTaskAssignTeam == null) {
        break missingId;
      }

      id = R.id.editText_EditTask_Description;
      EditText editTextEditTaskDescription = ViewBindings.findChildViewById(rootView, id);
      if (editTextEditTaskDescription == null) {
        break missingId;
      }

      id = R.id.spinner_EditTask_Complexity;
      Spinner spinnerEditTaskComplexity = ViewBindings.findChildViewById(rootView, id);
      if (spinnerEditTaskComplexity == null) {
        break missingId;
      }

      id = R.id.spinner_EditTask_Emergency;
      Spinner spinnerEditTaskEmergency = ViewBindings.findChildViewById(rootView, id);
      if (spinnerEditTaskEmergency == null) {
        break missingId;
      }

      id = R.id.spinner_EditTask_Size;
      Spinner spinnerEditTaskSize = ViewBindings.findChildViewById(rootView, id);
      if (spinnerEditTaskSize == null) {
        break missingId;
      }

      id = R.id.spinner_EditTask_Status;
      Spinner spinnerEditTaskStatus = ViewBindings.findChildViewById(rootView, id);
      if (spinnerEditTaskStatus == null) {
        break missingId;
      }

      return new ActivityEditTaskBinding((RelativeLayout) rootView, ImageEditTaskBackArrow,
          ImageEditTaskSaveIcon, LBLEditTaskDescriptionContent, LBLEditTaskTaskName,
          LBLTASKDescriptionLine, LBLTASKPeopleAssignedLine, LBLTaskDescription,
          LBLTaskPeopleAssigned, editTextEditTaskAssignTeam, editTextEditTaskDescription,
          spinnerEditTaskComplexity, spinnerEditTaskEmergency, spinnerEditTaskSize,
          spinnerEditTaskStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
