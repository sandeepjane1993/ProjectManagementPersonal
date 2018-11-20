package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask;

public interface TeamMenberListByTaskInterface {
    interface Presenter{
        void initview();


        void retrofitcall();
    }

    interface View{

        void initview();

        void retrofit();
    }
    interface FragmentView{

        void initview2();

        void retrofit();
    }
}
