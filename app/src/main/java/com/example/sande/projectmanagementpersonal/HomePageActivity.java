package com.example.sande.projectmanagementpersonal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sande.projectmanagementpersonal.project.ProjectListFragment;
import com.example.sande.projectmanagementpersonal.team.EmployeeListFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskDetailById.ViewTaskDetailByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskLiskById.ViewTaskListByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.ViewTeamMenberByTask;

import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskDetailById.ViewTaskDetailByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskLiskById.ViewTaskListByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.ViewTeamMenberByTask;

public class HomePageActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomePageFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProjectListFragment()).
                            addToBackStack(null)
                            .commit();
                    return true;
                case R.id.navigation_team:
                    //mTextMessage.setText(R.string.title_notifications);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new EmployeeListFragment()).addToBackStack("null").commit();
                    //this one for test only
                   /* getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new ViewTeamMenberByTask()).
                            addToBackStack(null)
                            .commit();*/
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomePageFragment()).commit();
    }

}
