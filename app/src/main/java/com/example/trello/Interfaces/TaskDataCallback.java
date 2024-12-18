package com.example.trello.Interfaces;


import com.example.trello.Models.Task;

import java.util.ArrayList;

public interface TaskDataCallback {
    void onCallback(ArrayList<Task> tasks);
}
