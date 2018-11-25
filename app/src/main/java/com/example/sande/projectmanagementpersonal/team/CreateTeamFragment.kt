package com.example.sande.projectmanagementpersonal.team

import android.content.Context
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
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.adapters.EmployeeListAdapter
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import com.example.sande.projectmanagementpersonal.pojo.MemberOfSubtaskPOJO
import org.jetbrains.anko.support.v4.toast

class CreateTeamFragment : Fragment(), EmployeeInterface, AdapterView.OnItemSelectedListener, EmployeeListAdapter.ClickListener {


    lateinit var employeeViewModel : EmployeeViewModel

    internal lateinit var spinner: Spinner

    lateinit var employeeId : String

    lateinit var employeeList: List<EmployeePOJO>

    lateinit var projectId : String

    lateinit var button : Button

    lateinit var sharePreference : SharedPreferences

    lateinit var recyclerView: RecyclerView

    val employeeAddedList : MutableList<EmployeePOJO> = mutableListOf()

    var adapterAdded  = EmployeeListAdapter(context, employeeAddedList)

    override fun onAttach(context: Context?) {
        employeeViewModel = EmployeeViewModel(this, context)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_create_team, container, false)

        employeeViewModel.initEmployeeList()

        sharePreference = context!!.getSharedPreferences("MyFile", Context.MODE_PRIVATE)

        val taskId  = sharePreference.getString("taskId", "")
        val subTaskId  = sharePreference.getString("subTaskId", "")

        recyclerView = view.findViewById(R.id.recyclerView_EmployeeAdded)

        spinner = view.findViewById(R.id.sp_add_employee)

        projectId = arguments!!.getString("projectId");

        adapterAdded.setClickListener(this)

        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            employeeViewModel.addEmployee(projectId, employeeId, taskId,  subTaskId)
            for (employeePOJO : EmployeePOJO in employeeList) {
                if (employeePOJO.empid == employeeId) {
                    if (!employeeAddedList.contains(employeePOJO)) {
                        employeeAddedList.add(employeePOJO)
                        Log.i("qqq", employeeId)
                        Log.i("qqq", employeePOJO.empid)
                        recyclerView.adapter = adapterAdded
                    }
                }
            }
        }

        return view;
    }

    override fun getEmployeeList(employeeList: List<EmployeePOJO>) {

        this.employeeList = employeeList

        val employeeListMutable : MutableList<String> = mutableListOf()

        for (employeePOJO : EmployeePOJO in employeeList) {
            var str : String = employeePOJO.toString()
            employeeListMutable.add(str)
        }

        var adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_spinner_item,
                employeeListMutable)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = this

//  employee added

        adapterAdded.notifyDataSetChanged()

        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapterAdded

    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        employeeId = employeeList.get(position).getEmpid()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        employeeId = employeeList.get(0).getEmpid()
    }

    override fun showAddEmployeeInfo(info: String) {
        toast(info)
    }

    override fun showMemberOfSubtask(memberOfSubtaskList: List<MemberOfSubtaskPOJO>) {
    }

    override fun itemClicked(view: View?, position: Int) {
    }

}