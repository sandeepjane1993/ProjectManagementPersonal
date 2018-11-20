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
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.adapters.EmployeeListAdapter
import com.example.sande.projectmanagementpersonal.adapters.SubTaskListAdapter
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import org.jetbrains.anko.support.v4.toast

class EmployeeListFragment : Fragment(), EmployeeInterface, EmployeeListAdapter.ClickListener {

    lateinit var employeeList: List<EmployeePOJO>

    lateinit var employeeViewModel : EmployeeViewModel
    lateinit var recyclerView: RecyclerView

    override fun onAttach(context: Context?) {
        (context?.applicationContext as MyApplication).componentInstance.injectRetrofit(this)
        employeeViewModel = EmployeeViewModel(this, context)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_employee_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerView_EmployeeList)

        employeeViewModel.initEmployeeList()

        return view
    }

    override fun getEmployeeList(employeeList: List<EmployeePOJO>) {

        this.employeeList = employeeList

        var mAdapter = EmployeeListAdapter(context, employeeList)

        mAdapter.setClickListener(this)
        Log.i("elf", "0")

        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }

    override fun itemClicked(view: View?, position: Int) {
        toast("Employee clicked 2")

        //employee clicked
    }

    override fun showAddEmployeeInfo(info: String) {
    }

}