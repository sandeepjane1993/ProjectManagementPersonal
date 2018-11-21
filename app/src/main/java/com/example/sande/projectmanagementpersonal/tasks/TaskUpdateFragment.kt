package com.example.sande.projectmanagementpersonal.tasks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.sande.projectmanagementpersonal.R

class TaskUpdateFragment : Fragment(), AdapterView.OnItemSelectedListener  {

    internal lateinit var spinner: Spinner

    lateinit var taskViewModel : TaskViewModel

    lateinit var button : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_task_update, container, false)

//        taskViewModel = TaskViewModel()

        spinner = view.findViewById(R.id.sp_update_task)
        button = view.findViewById(R.id.bt_update_task)

        initView()

        button.setOnClickListener { view ->
            taskViewModel.updateTask()
        }

        return view
    }

    private fun initView() {

        lateinit var adapter : ArrayAdapter<String>
        adapter.add("Start new project")
        adapter.add("Not complete")
        adapter.add("Completed")
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

}