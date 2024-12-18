package com.example.trello.Interfaces;

import com.example.trello.Models.Project;

import java.util.ArrayList;

public interface ProjectDataCallback {

    void onCallback(ArrayList<Project> projects);
}
