/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.StarRewardManagement;

/**
 *
 * @author ธนากร
 */
public class Employee {

    private String no;
    private String Name;
    private String departmentName;
    private String divisionName;
    private String positionName;
    private String pictureURL;
    private String goldStarGenGiveAmount;
    private String silverStarGenGiveAmount;
    private String bronzeStarGenGiveAmount;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getGoldStarGenGiveAmount() {
        return goldStarGenGiveAmount;
    }

    public void setGoldStarGenGiveAmount(String goldStarGenGiveAmount) {
        this.goldStarGenGiveAmount = goldStarGenGiveAmount;
    }

    public String getSilverStarGenGiveAmount() {
        return silverStarGenGiveAmount;
    }

    public void setSilverStarGenGiveAmount(String silverStarGenGiveAmount) {
        this.silverStarGenGiveAmount = silverStarGenGiveAmount;
    }

    public String getBronzeStarGenGiveAmount() {
        return bronzeStarGenGiveAmount;
    }

    public void setBronzeStarGenGiveAmount(String bronzeStarGenGiveAmount) {
        this.bronzeStarGenGiveAmount = bronzeStarGenGiveAmount;
    }

    @Override
    public String toString() {
        return "Employee{" + "Name=" + Name + ", departmentName=" + departmentName + ", divisionName=" + divisionName + ", positionName=" + positionName + ", goldStarGenGiveAmount=" + goldStarGenGiveAmount + ", silverStarGenGiveAmount=" + silverStarGenGiveAmount + ", bronzeStarGenGiveAmount=" + bronzeStarGenGiveAmount + '}';
    }

}
