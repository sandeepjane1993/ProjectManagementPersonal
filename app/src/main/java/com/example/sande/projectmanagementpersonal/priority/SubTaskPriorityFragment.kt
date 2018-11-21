package com.example.sande.projectmanagementpersonal.priority

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.R
import kotlinx.android.synthetic.main.fragment_subtask_priority.*
import kotlinx.android.synthetic.main.fragment_task_priority.*
import javax.inject.Inject





class SubTaskPriorityFragment : Fragment(), SubTaskPriority {


    lateinit var list: List<SubTaskPriorityPojo>

    lateinit var viewModel: SubTaskPriorityViewModel
    lateinit var recyclerView: RecyclerView
    @Inject
    internal lateinit var sharedPreferences: SharedPreferences

    override fun onAttach(context: Context?) {
        (context?.applicationContext as MyApplication).componentInstance.injectRetrofit(this)
        viewModel = SubTaskPriorityViewModel(this, context)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_subtask_priority, container, false)
        sharedPreferences = activity!!.getSharedPreferences("MyFile", Context.MODE_PRIVATE)
        Log.i("tag", sharedPreferences.getString("taskId", null)!!+
                sharedPreferences.getString("subTaskId", null)!!+
                sharedPreferences.getString("projectId", null)!!+
//                sharedPreferences.getString("14")!!
                "14")
        viewModel.callwebwservice(sharedPreferences.getString("taskId", null)!!,
                sharedPreferences.getString("subTaskId", null)!!,
                sharedPreferences.getString("projectId", null)!!,
//                sharedPreferences.getString("14")!!
                "14"
        )//Todo

        return view
    }

    override fun showePriority(response: SubTaskPriorityPojo) {
        Log.i("tag", response.toString())
        et_SubTaskpriorityTaskID.setText("Task id: " + response.taskid)
        et_SubTaskpriorityProjectID.setText("Project id: " + response.project_id)
        et_SubTaskprioritysubtaskid.setText("SubTask id: " + response.subtaskid)
        if (response.userid.equals("1")){
            et_SubTaskpriorityPriority.setText("Priority: Higher Priority")
        }
        else if (response.userid.equals("2")){
            et_SubTaskpriorityPriority.setText("Priority: Higher Priority")
        }
        else if (response.userid.equals("3")){
            et_SubTaskpriorityPriority.setText("Priority: Higher Priority")
        }
        else{
            et_SubTaskpriorityPriority.setText("Plz set Priority to 1,2,3 base one requirement. \n" +
                    " otherwise other people's code not work\n" +"your enter is: "+
                    response.userid)
        }
    }


}
