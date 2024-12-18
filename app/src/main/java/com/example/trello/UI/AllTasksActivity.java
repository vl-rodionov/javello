package com.example.trello.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trello.Adapters.ViewPagerAllTasksAdapter;
import com.example.trello.Adapters.ViewPagerTasksAdapter;
import com.example.trello.R;
import com.example.trello.Utils.DrawerBaseActivity;
import com.example.trello.Utils.MySP;
import com.example.trello.databinding.ActivityAllTasksBinding;
import com.example.trello.databinding.ActivityTasksBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;

public class AllTasksActivity extends DrawerBaseActivity {

    public static String projectID;
    ActivityAllTasksBinding activityAllTasksBinding;
    ViewPagerAllTasksAdapter adapter;
    private TabLayout tab;
    private ViewPager viewPager;
    private ShapeableImageView backArrow;
    private ShapeableImageView addTask;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAllTasksBinding = ActivityAllTasksBinding.inflate(getLayoutInflater());
        setContentView(activityAllTasksBinding.getRoot());
        allocateActivityTitle("All Tasks");


        findViews();
        email = MySP.getInstance().getEmail();
        adapter = new ViewPagerAllTasksAdapter(getSupportFragmentManager(), email);
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeView();
            }
        });

    }

    private void openHomeView() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void findViews() {
        tab = findViewById(R.id.tab_AllTasks_tab);
        viewPager = findViewById(R.id.viewPager_AllTasks_ViewPager);
        backArrow = findViewById(R.id.Image_AllTasks_backArrow);


    }


}