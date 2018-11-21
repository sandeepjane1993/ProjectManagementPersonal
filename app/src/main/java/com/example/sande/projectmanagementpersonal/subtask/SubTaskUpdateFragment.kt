package com.example.sande.projectmanagementpersonal.subtask

import android.content.Context
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
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse
import org.jetbrains.anko.support.v4.toast

class SubTaskUpdateFragment : Fragment(), AdapterView.OnItemSelectedListener, SubTaskInterface {

    override fun initRV(subTaskList: List<SubTaskListPOJO>) {
    }

    internal lateinit var spinner: Spinner

    lateinit var subtaskViewModel : SubTaskViewModel

    lateinit var button : Button

    lateinit var status : String

    override fun onAttach(context: Context?) {

        super.onAttach(context)
        subtaskViewModel = SubTaskViewModel(this, context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_subtask_update, container, false)

        spinner = view.findViewById(R.id.sp_update_subtask)
        button = view.findViewById(R.id.bt_update_subtask)

        initView()

        button.setOnClickListener { view ->
            subtaskViewModel.updateSubTask(status)
        }

        return view
    }

    private fun initView() {

        val statusListMutable : MutableList<String> = mutableListOf()

        var adapter : ArrayAdapter<String> = ArrayAdapter<String>(context!!, android.R.layout.simple_spinner_item,
                statusListMutable)

        adapter.add("Start new project")
        adapter.add("Not complete")
        adapter.add("Completed")
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = this
    }

    override fun updateSubTaskResponse(updateSubtaskResponse: UpdateSubtaskResponse) {
        val message = updateSubtaskResponse.message.get(0)
        toast(message)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        status = "1";
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        status = (position + 1).toString()
    }
}