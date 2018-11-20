package com.example.sande.projectmanagementpersonal.viewtaskByid.ViewTeamMenberByTask;

import com.google.gson.annotations.SerializedName;

public class EmployeeDetailPOJO {

    @SerializedName("userid")
    private String userid;
    @SerializedName("userfirstname")
    private String userfirstname;
    @SerializedName("userlastname")
    private String userlastname;
    @SerializedName("useremail")
    private String useremail;
    @SerializedName("usermobile")
    private String usermobile;

    public EmployeeDetailPOJO(String userid, String userfirstname, String userlastname, String useremail, String usermobile) {
        this.userid = userid;
        this.userfirstname = userfirstname;
        this.userlastname = userlastname;
        this.useremail = useremail;
        this.usermobile = usermobile;
    }

    @Override
    public String toString() {
        return "EmployeeDetailPOJO{" +
                "userid='" + userid + '\'' +
                ", userfirstname='" + userfirstname + '\'' +
                ", userlastname='" + userlastname + '\'' +
                ", useremail='" + useremail + '\'' +
                ", usermobile='" + usermobile + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }
}
