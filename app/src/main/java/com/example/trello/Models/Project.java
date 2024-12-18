package com.example.trello.Models;

import com.example.trello.Data.DataManager;

import java.util.ArrayList;
import java.util.List;

import com.example.trello.Data.DataManager.Emergency;
import com.example.trello.Data.DataManager.Size;
import com.example.trello.Data.DataManager.Complexity;

public class Project {


    private String projectName;

    private String projectManagerEmail;

    private String description;

    private List<String> team;


    private DataManager.Complexity complexity;

    private Size size;

    private Emergency emergency;

    private ArrayList<Task> tasks;

    private String projectID;

    public Project(String projectName, String projectManagerEmail, String description, List<String> team, Complexity complexity, Size size, Emergency emergency, String projectID) {
        this.projectName = projectName;
        this.projectManagerEmail = projectManagerEmail;
        this.description = description;
        this.team = team;
        this.complexity = complexity;
        this.size = size;
        this.emergency = emergency;
        this.projectID = projectID;
    }

    public Project() {
    }

    public String getComplexityString() {
        if (this.complexity == Complexity.COMPLEX)
            return "Complex";
        if (this.complexity == Complexity.VERY_COMPLEX)
            return "Very Complex";
        if (this.complexity == Complexity.REGULAR)
            return "Regular";
        return "Easy";
    }

    public String getSizeString() {

        if (this.size == Size.VERY_BIG)
            return "Very Big";
        if (this.size == Size.BIG)
            return "Big";
        if (this.size == Size.REGULAR)
            return "Regular";
        return "Small";
    }

    public String getEmergencyString() {

        if (this.emergency == Emergency.ASAP)
            return "ASAP";
        if (this.emergency == Emergency.HIGH)
            return "High";
        if (this.emergency == Emergency.MEDIUM)
            return "Medium";
        return "Low";
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManagerEmail() {
        return projectManagerEmail;
    }

    public void setProjectManagerEmail(String projectManagerEmail) {
        this.projectManagerEmail = projectManagerEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTeam() {
        return team;
    }

    public void setTeam(List<String> team) {
        this.team = team;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }


}
