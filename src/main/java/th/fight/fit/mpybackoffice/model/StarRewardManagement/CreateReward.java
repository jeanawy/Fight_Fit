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
public class CreateReward {

    private String rewardTh; //M
    private String rewardEn;//M
    private String descTh;
    private String descEn;
    private String conditionTh;

    private String conditionEn;
    private String activeDate; //M
    private String showStartDate; //M
    private String showEndDate; //M
    private String redeemExpDate; //M

    private String exchangeExpDate; //M
    private String quantity; //M
    private String starAmount; //M
    private String uidCanScan; //M
    private String pictureUrl;

    private String groupID;
    private String departmentID;
    private String divisionID;
    private String searchName;
    private String employeeID;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(String divisionID) {
        this.divisionID = divisionID;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRewardTh() {
        return rewardTh;
    }

    public void setRewardTh(String rewardTh) {
        this.rewardTh = rewardTh;
    }

    public String getRewardEn() {
        return rewardEn;
    }

    public void setRewardEn(String rewardEn) {
        this.rewardEn = rewardEn;
    }

    public String getDescTh() {
        return descTh;
    }

    public void setDescTh(String descTh) {
        this.descTh = descTh;
    }

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
    }

    public String getConditionTh() {
        return conditionTh;
    }

    public void setConditionTh(String conditionTh) {
        this.conditionTh = conditionTh;
    }

    public String getConditionEn() {
        return conditionEn;
    }

    public void setConditionEn(String conditionEn) {
        this.conditionEn = conditionEn;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getShowStartDate() {
        return showStartDate;
    }

    public void setShowStartDate(String showStartDate) {
        this.showStartDate = showStartDate;
    }

    public String getShowEndDate() {
        return showEndDate;
    }

    public void setShowEndDate(String showEndDate) {
        this.showEndDate = showEndDate;
    }

    public String getRedeemExpDate() {
        return redeemExpDate;
    }

    public void setRedeemExpDate(String redeemExpDate) {
        this.redeemExpDate = redeemExpDate;
    }

    public String getExchangeExpDate() {
        return exchangeExpDate;
    }

    public void setExchangeExpDate(String exchangeExpDate) {
        this.exchangeExpDate = exchangeExpDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStarAmount() {
        return starAmount;
    }

    public void setStarAmount(String starAmount) {
        this.starAmount = starAmount;
    }

    public String getUidCanScan() {
        return uidCanScan;
    }

    public void setUidCanScan(String uidCanScan) {
        this.uidCanScan = uidCanScan;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "CreateReward{" + "rewardTh=" + rewardTh + ", rewardEn=" + rewardEn + ", descTh=" + descTh + ", descEn=" + descEn + ", conditionTh=" + conditionTh + ", conditionEn=" + conditionEn + ", activeDate=" + activeDate + ", showStartDate=" + showStartDate + ", showEndDate=" + showEndDate + ", redeemExpDate=" + redeemExpDate + ", exchangeExpDate=" + exchangeExpDate + ", quantity=" + quantity + ", starAmount=" + starAmount + ", uidCanScan=" + uidCanScan + ", pictureUrl=" + pictureUrl + ", groupID=" + groupID + ", departmentID=" + departmentID + ", divisionID=" + divisionID + ", searchName=" + searchName + ", employeeID=" + employeeID + '}';
    }

}
