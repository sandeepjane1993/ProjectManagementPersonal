package com.example.sande.projectmanagementpersonal.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.pojo.MemberOfSubtaskPOJO

class MemberOfSubtaskAdapter(val memberOfSubtaskList: List<MemberOfSubtaskPOJO>) : RecyclerView.Adapter<MemberOfSubtaskAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.employee_by_subtask_itemview,
                parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.assignid.text = "assignid: " + memberOfSubtaskList?.get(position)?.getAssignid()
        holder.taskid.text = "taskid: " + memberOfSubtaskList?.get(position)?.getTaskid()
        holder.subtaskid.text = "subtaskid: " + memberOfSubtaskList?.get(position)?.getSubtaskid()
        holder.projectid.text = "projectid: " + memberOfSubtaskList?.get(position)?.getProjectid()
        holder.userid.text = "userid: " + memberOfSubtaskList?.get(position)?.getUserid()
    }

    override fun getItemCount(): Int {
        return memberOfSubtaskList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var assignid = itemView.findViewById<TextView>(R.id.tv_assignid)
        var taskid = itemView.findViewById<TextView>(R.id.tv_taskid)
        var subtaskid = itemView.findViewById<TextView>(R.id.tv_subtaskid)
        var projectid = itemView.findViewById<TextView>(R.id.tv_projectid)
        var userid = itemView.findViewById<TextView>(R.id.tv_userid)
    }
}