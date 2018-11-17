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

import java.util.List;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {


    private ClickListener clickListener;
    private List<ProjectListPOJO> projectList;
    Context ctx;

    public ProjectListAdapter(List<ProjectListPOJO> projectList, Context ctx) {
        this.projectList = projectList;
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

        ProjectListPOJO projectListPOJO = projectList.get(position);
        viewHolder.tv_projectList.setText("Project Id : " + projectListPOJO.getProjectId() + "\n" +
                "Project Name : " + projectListPOJO.getProjectName());

    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_projectList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_projectList = itemView.findViewById(R.id.tv_projectList_adapter);

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
