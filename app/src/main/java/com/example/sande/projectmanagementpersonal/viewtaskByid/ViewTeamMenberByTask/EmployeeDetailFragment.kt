package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.adapters.EmployeeListAdapter
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import com.example.sande.projectmanagementpersonal.subtask.SubTaskViewModel
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTaskLiskById.ViewTaskListByIDFragment
import kotlinx.android.synthetic.main.fragment_employee_detail.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class EmployeeDetailFragment : Fragment(), EmployeedetailInterface {


    lateinit var employeeList: List<EmployeePOJO>

    lateinit var employeeDetailViewModel : EmployeeDetailViewModel
    lateinit var recyclerView: RecyclerView
    @Inject
    internal lateinit var sharedPreferences: SharedPreferences

    override fun onAttach(context: Context?) {
        (context?.applicationContext as MyApplication).componentInstance.injectRetrofit(this)
        employeeDetailViewModel = EmployeeDetailViewModel(this, context)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_employee_detail, container, false)
        sharedPreferences= activity!!.getSharedPreferences("MyFile", MODE_PRIVATE)
        Log.i("tag",sharedPreferences.getString("memberuserid",null))
        employeeDetailViewModel.initEmployeeList(sharedPreferences.getString("memberuserid",null))

        return view
    }


    override fun showresult(response: EmployeeDetailPOJO) {
        Log.i("tag",response.toString())
         //To change body of created functions use File | Settings | File Templates.
        et_employeedetail_userid.setText("Employee id: "+response.userid)
        et_employeedetail_useremail.setText("Mobile: "+response.useremail)
        et_employeedetail_userfirstname.setText("Firstname: "+response.userfirstname)
        et_employeedetail_userlastname.setText("Lastname: "+response.userlastname)
        et_employeedetail_usermobile.setText("Mobile: "+response.usermobile)
    }
}