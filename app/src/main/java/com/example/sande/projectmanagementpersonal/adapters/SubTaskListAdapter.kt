package com.example.sande.projectmanagementpersonal.adapters

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.pojo.SubTaskListPOJO
import com.example.sande.projectmanagementpersonal.subtask.SubTaskDetailFragment
import org.jetbrains.anko.toast

//import kotlinx.android.synthetic.main.subtask_itemview.view.*

class SubTaskListAdapter(val context: Context?, val subTaskList: List<SubTaskListPOJO>?):
        RecyclerView.Adapter<SubTaskListAdapter.MyViewHolder>() {

//    var subTaskList = listOf<SubTaskListPOJO>()

/*    fun setData(items: List<SubTaskListPOJO>) {
        subTaskList = items
        notifyDataSetChanged()
    }*/

/*
    fun changedPositions(positions: Int) {
        notifyItemChanged(positions)
    }*/

    private var clickListener: ClickListener? = null

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val itemBinding : ItemBinding
        val view : View = inflater.inflate(R.layout.subtask_itemview, parent, false)

        sharedPreferences = context!!.getSharedPreferences("MyFile",MODE_PRIVATE);

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.subTaskId.text = "Id: " + subTaskList?.get(position)?.subtaskId
        holder.subTaskName.text = "Name: " + subTaskList?.get(position)?.subtaskName
        holder.subTaskStatus.text = "Status: " + subTaskList?.get(position)?.subtaskStatus
        holder.subTaskDescription.text = "Description: " + subTaskList?.get(position)?.subtaskDescription
        holder.subTaskStartDate.text = "Date: " + subTaskList?.get(position)?.startDate + " - " + subTaskList?.get(position)?.endDate

//        val editor : sharedPreferences.Editor  = sharedPreferences.edit();

        val editor = sharedPreferences.edit()
        editor.putString("subTaskId", subTaskList?.get(position)?.subtaskId)
        editor.commit()

        holder.itemView.setOnClickListener { view ->
            val starter : AppCompatActivity = view.context as AppCompatActivity

            starter.toast("Subtask clicked")

            if (clickListener != null) {
                clickListener!!.itemClicked(view, position)
            }


            /*starter.supportFragmentManager
                    .beginTransaction().replace(R.id.container, SubTaskDetailFragment()).addToBackStack(null).commit()*/
        }
    }

    override fun getItemCount(): Int {
        return subTaskList!!.size
    }

    fun setClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }


    inner class MyViewHolder(itemView: View ): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            Log.i("elf", "2")
            if (clickListener != null) {
                Log.i("elf", "3")
                clickListener!!.itemClicked(v, adapterPosition)
            }
        }

        var subTaskId = itemView.findViewById<TextView>(R.id.tvSubId)
        var subTaskName = itemView.findViewById<TextView>(R.id.tvSubTaskName)
        var subTaskStatus = itemView.findViewById<TextView>(R.id.tvSubTaskStatus)
        var subTaskDescription = itemView.findViewById<TextView>(R.id.tvSubTaskDescription)
        var subTaskStartDate = itemView.findViewById<TextView>(R.id.tvSubTaskStartDate)

    }

    interface ClickListener {
        fun itemClicked(view: View?, position: Int)
    }

}