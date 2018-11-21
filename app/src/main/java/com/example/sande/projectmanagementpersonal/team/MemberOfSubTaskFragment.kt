package com.example.sande.projectmanagementpersonal.team

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.adapters.MemberOfSubtaskAdapter
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import com.example.sande.projectmanagementpersonal.pojo.MemberOfSubtaskPOJO

class MemberOfSubTaskFragment : Fragment(), EmployeeInterface{

    lateinit var employeeViewModel : EmployeeViewModel
    lateinit var recyclerView: RecyclerView

    override fun onAttach(context: Context?) {
//        (context?.applicationContext as MyApplication).componentInstance.injectRetrofit(this)
        employeeViewModel = EmployeeViewModel(this, context)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_view_member_by_subtask, container, false)

        recyclerView = view.findViewById(R.id.recyclerView_EmployeeListBySubtask)


        employeeViewModel.getEmployeeListBySubtask()

        return view

    }

    override fun showMemberOfSubtask(memberOfSubtaskList: List<MemberOfSubtaskPOJO>) {
        val mAdapter = MemberOfSubtaskAdapter(memberOfSubtaskList)


        Log.i("mst", "0")

        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }

    override fun showAddEmployeeInfo(info: String) {
    }

    override fun getEmployeeList(employeeList: List<EmployeePOJO>) {
    }

}