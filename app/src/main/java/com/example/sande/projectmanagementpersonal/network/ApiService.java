package com.example.sande.projectmanagementpersonal.network;

import com.example.sande.projectmanagementpersonal.pojo.ForgotPasswordPOJO;
import com.example.sande.projectmanagementpersonal.pojo.LoginPOJO;
import com.example.sande.projectmanagementpersonal.priority.SubTaskPriorityPojo;
import com.example.sande.projectmanagementpersonal.priority.TaskPriorityPojo;
import com.example.sande.projectmanagementpersonal.responses.CreateTeamResponse;
import com.example.sande.projectmanagementpersonal.responses.EmployeeListResponse;
import com.example.sande.projectmanagementpersonal.responses.MemberOfSubtaskResponse;
import com.example.sande.projectmanagementpersonal.responses.ProjectCreateResponse;
import com.example.sande.projectmanagementpersonal.responses.ProjectListResponse;
import com.example.sande.projectmanagementpersonal.responses.SubTaskListResponse;
import com.example.sande.projectmanagementpersonal.responses.TaskListResponse;
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskDetailById.ViewSubTaskDetailByIdPojo;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById.ViewSubTaskListByIdResponce;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskDetailById.ViewTaskDetailByIdPojo;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskLiskById.ViewTaskListByIdResponce;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.EmployeeDetailPOJO;
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask.TeamMenberListByTaskResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    //http://rjtmobile.com/aamir/pms/android-app/pms_reg.php?first_name=aamir&last_name=husain&email=aa@aa.com&mobile=9876543210&password=12345678&company_size=500&your_role=TL
    @GET("http://rjtmobile.com/aamir/pms/android-app/pms_reg.php?")
    Observable<String> register(@Query("first_name") String fN, @Query("last_name") String lN, @Query("email") String email, @Query("mobile") String mobile,
                                @Query("password") String password, @Query("company_size") String cs, @Query("your_role") String role);

    //http://rjtmobile.com/aamir/pms/android-app/pms_login.php?email=aa@aa.com&password=12345678
    @GET("/aamir/pms/android-app/pms_login.php?")
    Observable<LoginPOJO> login(@Query("email") String email, @Query("password") String password);

    //http://rjtmobile.com/aamir/pms/android-app/pms_forgot_pass.php?email=aa@aa.com
    @GET("/aamir/pms/android-app/pms_forgot_pass.php?")
    Observable<ForgotPasswordPOJO> forgotPassword(@Query("email") String email);

    //http://rjtmobile.com/aamir/pms/android-app/pms_projects.php?
    @GET("/aamir/pms/android-app/pms_projects.php?")
    Observable<ProjectListResponse> getProjectsList();

    //http://rjtmobile.com/aamir/pms/android-app/pms_create_project.php?project_name=ecomm&project_status=1&project_desc=xyz&start_date=2018-04-03&end_date=2018-04-15
    @GET("/aamir/pms/android-app/pms_create_project.php?")
    Observable<ProjectCreateResponse> createProject(@Query("project_name") String name,@Query("project_status") String status,
                                                    @Query("project_desc") String desc,@Query("start_date") String start,@Query("end_date") String end);

    //http://rjtmobile.com/aamir/pms/android-app/pms_edit_project.php?project_id=27&project_name=e-commerce&project_status=1&project_desc=xyzss&start_date=2018-04-05&end_end=2018-04-15
    @GET("/aamir/pms/android-app/pms_edit_project.php?")
    Observable<ProjectCreateResponse> updateProject(@Query("project_id") String id,@Query("project_name") String name,@Query("project_status") String status,
                                                    @Query("project_desc") String desc,@Query("start_date") String start,@Query("end_date") String end);

    //http://rjtmobile.com/aamir/pms/android-app/pms_project_task_list.php?
    @GET("/aamir/pms/android-app/pms_project_task_list.php?")
    Observable<TaskListResponse> getTaskList();

    //http://rjtmobile.com/aamir/pms/android-app/pms_create_task.php?project_id=27&task_name=category screen&task_status=1&task_desc=xyz&start_date=2018-04-03&end_date=2018-04-15
    @GET("/aamir/pms/android-app/pms_create_task.php?")
    Observable<ProjectCreateResponse> createTask(@Query("project_id") String projectId,@Query("task_name") String name,@Query("task_status") String status,
                                                 @Query("task_desc")String desc,@Query("start_date") String start,@Query("end_date") String end);

    //http://rjtmobile.com/aamir/pms/android-app/pms_create_sub_task.php?project_id=27&task_id=1&sub_task_name=category screen image loading&sub_task_status=1&sub_task_desc=xyz&start_date=2018-04-03&end_date=2018-04-15
    @GET("/aamir/pms/android-app/pms_create_sub_task.php?")
    Observable<ProjectCreateResponse> createSubTask(@Query("project_id") String projectId,@Query("task_id") String taskId,@Query("sub_task_name") String name,
                                                    @Query("sub_task_status")String status,@Query("sub_task_desc") String desc,
                                                    @Query("start_date") String start,@Query("end_date") String end);

    @GET("/aamir/pms/android-app/pms_view_task.php?")
    Call<ViewTaskListByIdResponce> get_View_task_list_by_id_response(@Query("user_id") String id);

    @GET("/aamir/pms/android-app/pms_view_task_deatil.php?")
    Call<ViewTaskDetailByIdPojo> get_View_task_detail_by_id_response(@Query("taskid") String taskid, @Query("project_id") String project_id);

    @GET("/aamir/pms/android-app/pms_view_subtask.php?")
    Call<ViewSubTaskListByIdResponce> get_View_Subtask_list_by_id_response(@Query("user_id") String id,@Query("taskid") String taskid);

    @GET("/aamir/pms/android-app/pms_view_sub_task_deatil.php?")
    Call<ViewSubTaskDetailByIdPojo> get_View_Subtask_detail_by_id_response(@Query("taskid") String taskid,@Query("subtask_id") String subtask_id, @Query("project_id") String project_id);

    @GET("/aamir/pms/android-app/pms_team_task.php?")
    Observable<TeamMenberListByTaskResponse> getTeamListByTask(@Query("taskid") String taskid, @Query("projectid") String projectid);
    @GET("/aamir/pms/android-app/pms_project_sub_task_list.php?")
    Observable<SubTaskListResponse> getSubTaskList();

    @GET("/aamir/pms/android-app/pms_employee_list.php?")
    Observable<EmployeeListResponse> getEmployeeList();

    @GET("/aamir/pms/android-app/pms_create_project_team.php?")
    Observable<CreateTeamResponse> createTeam(@Query("project_id") String project_id,
                                              @Query("team_member_userid") String team_member_userid);
    @GET("/aamir/pms/android-app/pms_team_member_deatil.php?")
    Observable<EmployeeDetailPOJO> getEmployeeDetail(@Query("memberuserid") String memberuserid);

    @GET("/aamir/pms/android-app/pms_team_sub_task.php?")
    Observable<MemberOfSubtaskResponse> getMemberOfSubtask(@Query("taskid") String taskid,
                                                           @Query("subtaskid") String subtaskid, @Query("projectid") String projectid);
    @GET("/aamir/pms/android-app/pms_view_task_priority.php?")
    Observable<TaskPriorityPojo> getTaskPriority(@Query("taskid") String taskid,@Query("project_id") String project_id,@Query("userid") String userid);
    @GET("/aamir/pms/android-app/pms_view_sub_task_priority.php?")
    Observable<SubTaskPriorityPojo> getSubTaskPriority(@Query("taskid") String taskid, @Query("subtaskid") String subtask_id, @Query("project_id") String project_id, @Query("userid") String userid);

    //http://rjtmobile.com/aamir/pms/android-app/pms_assign_task_project.php?task_id=1&project_id=27&team_member_userid=14
    @GET("/aamir/pms/android-app/pms_assign_task_project.php?")
    Call<ProjectCreateResponse> assignTaskToMember(@Query("task_id") String taskId,@Query("project_id") String projectId,@Query("team_member_userid") String userId);

    //http://rjtmobile.com/aamir/pms/android-app/pms_assign_sub_task_project.php?task_id=1&subtask_id=1&project_id=27&team_member_userid=14
    @GET("/aamir/pms/android-app/pms_assign_sub_task_project.php?")
    Observable<ProjectCreateResponse> assignSubTaskToMember(@Query("task_id")String taskId,@Query("subtask_id") String subTaskId,@Query("project_id") String project_id,@Query("team_member_userid") String team_member_userid);

    @GET("/aamir/pms/android-app/pms_edit_sub_task_status.php?")
    Observable<UpdateSubtaskResponse> updateSubtask(@Query("subtaskid") String taskid,
                                                    @Query("taskid") String subtaskid, @Query("project_id") String project_id,
                                                    @Query("userid") String userid, @Query("task_status") String task_status);

    @GET("/aamir/pms/android-app/pms_edit_task_status.php?")
    Call<UpdateSubtaskResponse> updateTask(@Query("taskid") String subtaskid, @Query("project_id") String project_id,
                                                    @Query("userid") String userid, @Query("task_status") String task_status);
}
