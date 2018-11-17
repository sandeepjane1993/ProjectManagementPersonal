package com.example.sande.projectmanagementpersonal.network;

import com.example.sande.projectmanagementpersonal.pojo.ForgotPasswordPOJO;
import com.example.sande.projectmanagementpersonal.pojo.LoginPOJO;
import com.example.sande.projectmanagementpersonal.responses.ProjectCreateResponse;
import com.example.sande.projectmanagementpersonal.responses.ProjectListResponse;
import com.example.sande.projectmanagementpersonal.responses.TaskListResponse;

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
}
