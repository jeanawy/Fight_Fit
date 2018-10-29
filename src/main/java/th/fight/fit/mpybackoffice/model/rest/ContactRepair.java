/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest;

/**
 *
 * @author Jeep_
 */
public class ContactRepair {

    private String day;
    private String time;
    private String repairPictureURL1;
    private String repairPictureURL2;
    private String repairPictureURL3;
    private String repairPictureURL4;
    private String Name;
    private String departmentName;
    private String divisionName;
    private String repairRemark;
    private String buildingName;
    private String repairStatus;
    private String TransactionID;

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String TransactionID) {
        this.TransactionID = TransactionID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRepairPictureURL1() {
        return repairPictureURL1;
    }

    public void setRepairPictureURL1(String repairPictureURL1) {
        this.repairPictureURL1 = repairPictureURL1;
    }

    public String getRepairPictureURL2() {
        return repairPictureURL2;
    }

    public void setRepairPictureURL2(String repairPictureURL2) {
        this.repairPictureURL2 = repairPictureURL2;
    }

    public String getRepairPictureURL3() {
        return repairPictureURL3;
    }

    public void setRepairPictureURL3(String repairPictureURL3) {
        this.repairPictureURL3 = repairPictureURL3;
    }

    public String getRepairPictureURL4() {
        return repairPictureURL4;
    }

    public void setRepairPictureURL4(String repairPictureURL4) {
        this.repairPictureURL4 = repairPictureURL4;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getRepairRemark() {
        return repairRemark;
    }

    public void setRepairRemark(String repairRemark) {
        this.repairRemark = repairRemark;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    @Override
    public String toString() {
        return "ContactRepair{" + "day=" + day + ", time=" + time + ", repairPictureURL1=" + repairPictureURL1 + ", repairPictureURL2=" + repairPictureURL2 + ", repairPictureURL3=" + repairPictureURL3 + ", repairPictureURL4=" + repairPictureURL4 + ", Name=" + Name + ", departmentName=" + departmentName + ", divisionName=" + divisionName + ", repairRemark=" + repairRemark + ", buildingName=" + buildingName + ", repairStatus=" + repairStatus + ", TransactionID=" + TransactionID + '}';
    }

   

}
