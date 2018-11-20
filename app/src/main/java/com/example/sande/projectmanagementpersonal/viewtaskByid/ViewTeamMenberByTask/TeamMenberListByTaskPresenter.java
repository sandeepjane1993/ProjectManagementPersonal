package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask;

public class TeamMenberListByTaskPresenter implements TeamMenberListByTaskInterface.Presenter {

    TeamMenberListByTaskInterface.FragmentView view;
    public TeamMenberListByTaskPresenter(TeamMenberListByTaskInterface.FragmentView view) {
        this.view = view;
    }
    @Override
    public void initview() {
        view.initview2();
    }

    @Override
    public void retrofitcall() {
        view.retrofit();
    }
}
