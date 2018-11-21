package com.example.sande.projectmanagementpersonal.tasks

import android.app.Application
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.databinding.FragmentTaskUpdateBinding

class TaskUpdateFragment : Fragment(), AdapterView.OnItemSelectedListener  {

    internal lateinit var spinner: Spinner

    lateinit var taskViewModel : TaskViewModel

    lateinit var button : Button

    var status : String = ""

    override fun onAttach(context: Context?) {
        taskViewModel = TaskViewModel(context!!.applicationContext as Application)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view: View = inflater.inflate(R.layout.fragment_task_update, container, false)

        var binding : FragmentTaskUpdateBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_task_update, container, false)

        binding.mTaskViewModel = taskViewModel

        var view : View = binding.root

        spinner = view!!.findViewById(R.id.sp_update_task)
//        button = view!!.findViewById(R.id.bt_update_task)

        initView()

/*        button.setOnClickListener { view ->
            *//*Log.i("123", "yes-2")
            taskViewModel.updateTask(status)*//*
            Log.i("123", "yes-2")
        }*/

        taskViewModel.updateTask(status)

        return view
    }

    private fun initView() {

        var list : MutableList<String> = mutableListOf()

        var adapter = ArrayAdapter<String>(context!!, android.R.layout.simple_spinner_item,
                list)

        adapter.add("Start new project")
        adapter.add("Not complete")
        adapter.add("Completed")
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        status = "1";
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        status = (position + 1).toString()
    }

}