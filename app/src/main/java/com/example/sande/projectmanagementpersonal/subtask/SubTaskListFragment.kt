package com.example.sande.projectmanagementpersonal.subtask

import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sande.projectmanagementpersonal.BuildConfig
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.adapters.SubTaskListAdapter
/*import com.example.sande.projectmanagementpersonal.databinding.FragmentSubtasklistBinding*/
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO
import com.example.sande.projectmanagementpersonal.responses.UpdateSubtaskResponse
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject
import com.example.sande.projectmanagementpersonal.R.id.fab
import android.support.design.widget.CoordinatorLayout
import com.example.sande.projectmanagementpersonal.adapters.ProjectListAdapter
import com.example.sande.projectmanagementpersonal.project.ProjectDetailFragment


class SubTaskListFragment : Fragment(), SubTaskListAdapter.ClickListener,SubTaskInterface {
    override fun updateSubTaskResponse(updateSubtaskResponse: UpdateSubtaskResponse) {
    }

    lateinit var subTaskViewModel : SubTaskViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var subTaskList : MutableList<SubTaskListPOJO>
    lateinit var mAdapter : SubTaskListAdapter
    lateinit var taskId : String

    internal lateinit var fab: FloatingActionButton

    @Inject
    internal lateinit var sharedPreferences: SharedPreferences


    override fun onAttach(context: Context?) {
        subTaskViewModel = SubTaskViewModel(this, context!!)
        (context.applicationContext as MyApplication).componentInstance.injectRetrofit(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_subtasklist, container, false)

/*        val binding: FragmentSubtasklistBinding
                = DataBindingUtil.inflate(inflater,
                R.layout.fragment_subtasklist, container, false)

        val view:View = binding.root*/

        fab = view.findViewById<FloatingActionButton>(R.id.fab_taskList)

        if (BuildConfig.FLAVOR.equals("user", ignoreCase = true)) {

            fab.hide()
        }
        fab.setOnClickListener {

            fragmentManager!!.beginTransaction().replace(R.id.container,
                    SubTaskCreateFragment(), null).addToBackStack(null).commit()
        }

        recyclerView = view.findViewById(R.id.recyclerView_SubTaskList)

        subTaskViewModel.initsubTaskList();

        taskId = arguments!!.getString("taskId")

        return view
    }

    override fun initRV(subTaskList : List<SubTaskListPOJO>) {

        this.subTaskList = subTaskList as MutableList<SubTaskListPOJO>

        var validSubTaskList : MutableList<SubTaskListPOJO> = mutableListOf()

//        val taskId : String = sharedPreferences.getString("taskId", "")

        for (subTaskListPOJO : SubTaskListPOJO in subTaskList) {
            if (subTaskListPOJO.getTaskId() == taskId) {
                validSubTaskList.add(subTaskListPOJO)
            }
        }

        mAdapter = SubTaskListAdapter(context, validSubTaskList)

        mAdapter.setClickListener(this);


        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }

    override fun itemClicked(view: View?, position: Int) {
/*        val subTaskId = subTaskList.get(position).getSubtaskId()
        Log.i("subtask_id", subTaskList.get(position).toString())*/

/*        var bundle : Bundle = Bundle()
        bundle.putString("subTaskId", subTaskId)*/
        var subTaskDetailFragment : SubTaskDetailFragment = SubTaskDetailFragment()
//        subTaskDetailFragment.arguments = bundle
        fragmentManager!!.beginTransaction().replace(R.id.container, subTaskDetailFragment).addToBackStack(null).commit()
    }
}