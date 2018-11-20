package com.example.sande.projectmanagementpersonal.adapters

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sande.projectmanagementpersonal.R
import com.example.sande.projectmanagementpersonal.R.id.*
import com.example.sande.projectmanagementpersonal.pojo.EmployeePOJO
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

class EmployeeListAdapter(context: Context?, val employeeTaskList: List<EmployeePOJO>?):
        RecyclerView.Adapter<EmployeeListAdapter.MyViewHolder>() {

    private lateinit var clickListener: ClickListener

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EmployeeListAdapter.MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.employee_itemview, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeeTaskList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.empid.text = "id: " + employeeTaskList?.get(position)?.getEmpid()
        holder.empfirstname.text = "firstname: " + employeeTaskList?.get(position)?.getEmpfirstname()
        holder.emplastname.text = "lastnameid: " + employeeTaskList?.get(position)?.getEmplastname()
        holder.empemail.text = "email: " + employeeTaskList?.get(position)?.getEmpemail()
        holder.empmobile.text = "mobile: " + employeeTaskList?.get(position)?.getEmpmobile()
        holder.empdesignation.text = "designation: " + employeeTaskList?.get(position)?.getEmpdesignation()
        holder.dateofjoining.text = "dateofjoining: " + employeeTaskList?.get(position)?.getDateofjoining()

        holder.itemView.setOnClickListener { view ->
            val starter : AppCompatActivity = view.context as AppCompatActivity

            starter.toast("Employee clicked")

            if (clickListener != null) {
                clickListener.itemClicked(view, position)
            }
        }
    }

    fun setClickListener(clickListener: ClickListener) {
        Log.i("elf", "1")
        this.clickListener = clickListener
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener  {

        var empid = itemView.findViewById<TextView>(R.id.tv_empid)
        var empfirstname = itemView.findViewById<TextView>(tv_empfirstname)
        var emplastname = itemView.findViewById<TextView>(tv_emplastname)
        var empemail = itemView.findViewById<TextView>(tv_empemail)
        var empmobile = itemView.findViewById<TextView>(tv_empmobile)
        var empdesignation = itemView.findViewById<TextView>(tv_empdesignation)
        var dateofjoining = itemView.findViewById<TextView>(tv_dateofjoining)

        override fun onClick(v: View?) {
            Log.i("elf", "2")
            if (clickListener != null) {
                Log.i("elf", "3")
                clickListener.itemClicked(v, adapterPosition)
            }
        }
    }

    interface ClickListener {
        fun itemClicked(view: View?, position: Int)
    }

}