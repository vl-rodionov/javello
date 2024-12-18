package com.example.trello.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.trello.Fragments.BacklogFragment;
import com.example.trello.Fragments.DoingFragment;
import com.example.trello.Fragments.DoneFragment;


public class ViewPagerAllTasksAdapter extends FragmentPagerAdapter {

    private final String projectManagerEmail;


    public ViewPagerAllTasksAdapter(@NonNull FragmentManager fm, String projectManagerEmail) {
        super(fm);
        this.projectManagerEmail = projectManagerEmail;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            return new BacklogFragment("0", projectManagerEmail);
        } else if (position == 1) {

            return new DoingFragment("0", projectManagerEmail);
        } else {

            return new DoneFragment("0", projectManagerEmail);
        }
    }


    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Backlog";
        } else if (position == 1) {
            return "Doing";
        } else {
            return "Done";
        }
    }
}

