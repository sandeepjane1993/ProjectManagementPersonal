package com.example.sande.projectmanagementpersonal.di;

import com.example.sande.projectmanagementpersonal.login.ForgotPasswordFragment;
import com.example.sande.projectmanagementpersonal.login.LoginFragment;
import com.example.sande.projectmanagementpersonal.priority.SubTaskPriorityFragment;
import com.example.sande.projectmanagementpersonal.priority.SubTaskPriorityRepository;
import com.example.sande.projectmanagementpersonal.priority.TaskPriorityFragment;
import com.example.sande.projectmanagementpersonal.priority.TaskPriorityRepository;
import com.example.sande.projectmanagementpersonal.project.ProjectCreateFragment;
import com.example.sande.projectmanagementpersonal.project.ProjectListFragment;
import com.example.sande.projectmanagementpersonal.project.ProjectUpdateFragment;
import com.example.sande.projectmanagementpersonal.subtask.SubTaskCreateFragment;
import com.example.sande.projectmanagementpersonal.subtask.SubTaskDetailFragment;
import com.example.sande.projectmanagementpersonal.subtask.SubTaskListFragment;
import com.example.sande.projectmanagementpersonal.subtask.SubTaskRepository;
import com.example.sande.projectmanagementpersonal.tasks.TaskCreateFragment;
import com.example.sande.projectmanagementpersonal.tasks.TaskDetailFragment;
import com.example.sande.projectmanagementpersonal.tasks.TaskListFragment;
import com.example.sande.projectmanagementpersonal.team.EmployeeListFragment;
import com.example.sande.projectmanagementpersonal.team.EmployeeRepository;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskDetailById.ViewSubTaskDetailByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById.ViewSubTaskListByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskDetailById.ViewTaskDetailByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskLiskById.ViewTaskListByIDFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.EmployeeDetailFragment;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.EmployeeDetailRepository;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.ViewTeamMenberByTask;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, MySharedPreferenceModule.class})
public interface MyComponent {

    void injectRetrofit(LoginFragment fragment);

    void injectRetrofit(ForgotPasswordFragment fragment);

    void injectRetrofit(ProjectListFragment fragment);

    void injectRetrofit(ProjectCreateFragment fragment);

    void injectRetrofit(ProjectUpdateFragment fragment);

    void injectRetrofit(TaskListFragment fragment);

    void injectRetrofit(TaskCreateFragment fragment);

    void injectRetrofit(ViewTaskListByIDFragment fragment);

    void injectRetrofit(ViewTaskDetailByIDFragment fragment);

    void injectRetrofit(ViewSubTaskDetailByIDFragment fragment);

    void injectRetrofit(ViewSubTaskListByIDFragment fragment);
    void injectRetrofit(SubTaskCreateFragment fragment);


    void injectRetrofit(ViewTeamMenberByTask fragment);

    void injectRetrofit(SubTaskListFragment fragment);

    void injectRetrofit(EmployeeListFragment fragment);

    void injectRetrofit(EmployeeRepository fragment);

    void injectRetrofit(SubTaskRepository fragment);

    void injectRetrofit(TaskDetailFragment fragment);

    void injectRetrofit(SubTaskDetailFragment fragment);

    void injectRetrofit(EmployeeDetailFragment fragment);

    void injectRetrofit( EmployeeDetailRepository fragment);

    void injectRetrofit(TaskPriorityRepository fragment);

    void injectRetrofit(TaskPriorityFragment fragment);

    void injectRetrofit(SubTaskPriorityRepository fragment);

    void injectRetrofit(SubTaskPriorityFragment fragment);
}
