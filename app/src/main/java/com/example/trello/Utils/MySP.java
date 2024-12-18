package com.example.trello.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.trello.Models.Project;


public class MySP {

    private static final String DB_FILE = "DB_FILE";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_NAME = "Name";
    private static final String PROJECT_ID = "Project";

    private static MySP instance = null;
    private final SharedPreferences sharedPreferences;


    private MySP(Context context) {
        sharedPreferences = context.getSharedPreferences(DB_FILE, Context.MODE_PRIVATE);
    }


    public static void init(Context context) {
        if (instance == null) {
            instance = new MySP(context);
        }
    }


    public static MySP getInstance() {
        if (instance == null) {
            throw new IllegalStateException("MySP is not initialized. Call init() first.");
        }
        return instance;
    }


    public void saveEmail(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }


    public String getEmail() {
        return sharedPreferences.getString(KEY_EMAIL, "");
    }


    public void saveName(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.apply();
    }


    public String getName() {
        return sharedPreferences.getString(KEY_NAME, "");
    }


    public void saveProjectID(String projectID) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PROJECT_ID, projectID);
        editor.apply();
    }


    public String getProjectID() {
        return sharedPreferences.getString(PROJECT_ID, "");
    }
}
