/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.StarRewardManagement;

/**
 *
 * @author 58050232
 */
public class RedeemReward {

    private String createDate;
    private String empPic;
    private String empName;
    private String division;
    private String department;
    private String position;
    private String rewardPic;
    private String rewardName;
    private String desc;
    private String starType;
    private Integer quantity;
    private String rewardStatus;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEmpPic() {
        return empPic;
    }

    public void setEmpPic(String empPic) {
        this.empPic = empPic;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRewardPic() {
        return rewardPic;
    }

    public void setRewardPic(String rewardPic) {
        this.rewardPic = rewardPic;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRewardStatus() {
        return rewardStatus;
    }

    public void setRewardStatus(String rewardStatus) {
        this.rewardStatus = rewardStatus;
    }

    @Override
    public String toString() {
        return "RedeemReward{" + "createDate=" + createDate + ", empPic=" + empPic + ", empName=" + empName + ", division=" + division + ", department=" + department + ", position=" + position + ", rewardPic=" + rewardPic + ", rewardName=" + rewardName + ", desc=" + desc + ", starType=" + starType + ", quantity=" + quantity + ", rewardStatus=" + rewardStatus + '}';
    }

}
