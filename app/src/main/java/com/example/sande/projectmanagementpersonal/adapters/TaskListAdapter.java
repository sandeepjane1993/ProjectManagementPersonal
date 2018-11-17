package com.example.sande.projectmanagementpersonal.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sande.projectmanagementpersonal.R;
import com.example.sande.projectmanagementpersonal.pojo.ProjectListPOJO;
import com.example.sande.projectmanagementpersonal.pojo.TaskListPOJO;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private ClickListener clickListener;
    private List<TaskListPOJO> taskList;
    Context ctx;

    public TaskListAdapter(List<TaskListPOJO> taskList, Context ctx) {
        this.taskList = taskList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singleitem_project_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        TaskListPOJO taskListPOJO = taskList.get(position);
        viewHolder.tv_taskList.setText("Task Id : " + taskListPOJO.getTaskId() + "\n" +
                "Project Id : " + taskListPOJO.getProjectId() + "\n" +
                "Task Name : " + taskListPOJO.getTaskName());

    }
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_taskList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_taskList =itemView.findViewById(R.id.tv_projectList_adapter);
        }

        @Override
        public void onClick(View v) {

            if(clickListener != null)
            {
                clickListener.itemClicked(v,getAdapterPosition());
            }
        }
    }
    public interface ClickListener{

        public void itemClicked(View view, int position);
    }
}
