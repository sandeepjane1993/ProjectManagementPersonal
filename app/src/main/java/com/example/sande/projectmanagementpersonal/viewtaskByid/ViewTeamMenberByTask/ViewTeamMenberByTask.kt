
package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask
/*
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sande.projectmanagementpersonal.MyApplication
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.network.ApiService
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskDetailById.ViewSubTaskDetailByIDFragment
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById.ViewSubTaskListByIdPojo
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById.ViewSubTaskListByIdResponce
import com.example.sande.projectmanagementpersonal.viewtaskByid.ViewSubTaskListById.ViewSubTaskListByidAdapter
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

class ViewTeamMenberByTask : Fragment() {
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        */
/*arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*//*

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_view_team_menber_by_task, container, false)
        ///////////////////////////
        var mList: ArrayList<ViewSubTaskListByIdPojo>

        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.get_View_Subtask_list_by_id_response("15", sharedPreferences.getString("taskid", null))
        call.enqueue(object : Callback<ViewSubTaskListByIdResponce> {
            override fun onResponse(call: Call<ViewSubTaskListByIdResponce>, response: Response<ViewSubTaskListByIdResponce>) {
                val viewTaskListByIdResponce = response.body()
                if (viewTaskListByIdResponce!!.viewSubTaskListByIdPojos != null) {
                    mList = viewTaskListByIdResponce.viewSubTaskListByIdPojos
                    val adapter = ViewSubTaskListByidAdapter(activity, mList)
                    //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
                    val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                    rv.setLayoutManager(layoutManager)
                    rv.setAdapter(adapter)
                    adapter.notifyDataSetChanged()
                    adapter.setOnItemClickListener { v, position ->
                        val editor = sharedPreferences.edit()
                        editor.putString("projectid", mList.get(position).getProjectid())
                        editor.putString("taskid", mList.get(position).getTaskid())
                        editor.putString("subtaskid", mList.get(position).getSubtaskid())
                        editor.commit()
                        activity!!.supportFragmentManager
                                .beginTransaction()
                                .replace(R.id.container, ViewSubTaskDetailByIDFragment()).addToBackStack(null)
                                .commit()
                    }

                } else {
                    mList = ArrayList<ViewSubTaskListByIdPojo>()
                    val adapter = ViewSubTaskListByidAdapter(activity, mList)
                    //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
                    val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                    rv.setLayoutManager(layoutManager)
                    rv.setAdapter(adapter)
                }
            }

            override fun onFailure(call: Call<ViewSubTaskListByIdResponce>, t: Throwable) {
                toast(t.toString())
            }
        })
///////////////////////////
        return v
    }

    override fun onAttach(context: Context?) {
        (context!!.applicationContext as MyApplication).componentInstance.injectRetrofit(this)
        super.onAttach(context)
    }
}


*/
/* if (BuildConfig.FLAVOR.equals("manager")) {
            Toast.makeText(context, "Manager LvL", Toast.LENGTH_SHORT).show()
            view.tvCreateSubTask.visibility = View.VISIBLE
        } else if (BuildConfig.FLAVOR.equals("developer")) {
            view.tvCreateSubTask.visibility = View.GONE
        }*//*



*/
/*
disposable = apiServe.getTeamListByTask(
taskItem.taskid!!,
"99",
taskItem.projectid!!)
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
.subscribe(
{ result ->
    ninntag.warn { "nh: got result going to show member list" }
    viewModel.showTaskMemberList(listener, result.members)
    ninntag.warn { "nh: showed member list" }
},
{ error ->
    viewModel.showTaskMemberList(listener, null)
    ninntag.warn { "error: " + error.message }
}
)*/

