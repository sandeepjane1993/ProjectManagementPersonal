package com.example.sande.projectmanagementpersonal.pojo;

import com.google.gson.annotations.SerializedName;

public class EmployeePOJO {

    @SerializedName("empid")
    private String empid;
    @SerializedName("empfirstname")
    private String empfirstname;
    @SerializedName("emplastname")
    private String emplastname;
    @SerializedName("empemail")
    private String empemail;
    @SerializedName("empmobile")
    private String empmobile;
    @SerializedName("empdesignation")
    private String empdesignation;
    @SerializedName("dateofjoining")
    private String dateofjoining;

    public EmployeePOJO(String empid, String empfirstname,
                        String emplastname, String empemail,
                        String empmobile, String empdesignation, String dateofjoining) {
        this.empid = empid;
        this.empfirstname = empfirstname;
        this.emplastname = emplastname;
        this.empemail = empemail;
        this.empmobile = empmobile;
        this.empdesignation = empdesignation;
        this.dateofjoining = dateofjoining;
    }

    @Override
    public String toString() {
        return "empid='" + empid + '\'' +
                ", empfirstname='" + empfirstname + '\'' +
                ", emplastname='" + emplastname + '\'' +
                ", empemail='" + empemail + '\'' +
                ", empmobile='" + empmobile + '\'' +
                ", empdesignation='" + empdesignation + '\'' +
                ", dateofjoining='" + dateofjoining + '\'' ;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpfirstname() {
        return empfirstname;
    }

    public void setEmpfirstname(String empfirstname) {
        this.empfirstname = empfirstname;
    }

    public String getEmplastname() {
        return emplastname;
    }

    public void setEmplastname(String emplastname) {
        this.emplastname = emplastname;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmpmobile() {
        return empmobile;
    }

    public void setEmpmobile(String empmobile) {
        this.empmobile = empmobile;
    }

    public String getEmpdesignation() {
        return empdesignation;
    }

    public void setEmpdesignation(String empdesignation) {
        this.empdesignation = empdesignation;
    }

    public String getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(String dateofjoining) {
        this.dateofjoining = dateofjoining;
    }
}
