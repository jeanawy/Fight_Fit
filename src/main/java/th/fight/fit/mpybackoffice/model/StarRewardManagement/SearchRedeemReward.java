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
public class SearchRedeemReward {
    private String searchUser;
    private String searchRewardName;
    private String requestDay;
    private String searchByStatus;

    public String getSearchUser() {
        return searchUser;
    }

    public void setSearchUser(String searchUser) {
        this.searchUser = searchUser;
    }

    public String getSearchRewardName() {
        return searchRewardName;
    }

    public void setSearchRewardName(String searchRewardName) {
        this.searchRewardName = searchRewardName;
    }

    public String getRequestDay() {
        return requestDay;
    }

    public void setRequestDay(String requestDay) {
        this.requestDay = requestDay;
    }

    public String getSearchByStatus() {
        return searchByStatus;
    }

    public void setSearchByStatus(String searchByStatus) {
        this.searchByStatus = searchByStatus;
    }

    @Override
    public String toString() {
        return "SearchRedeemReward{" + "searchUser=" + searchUser + ", searchRewardName=" + searchRewardName + ", requestDay=" + requestDay + ", searchByStatus=" + searchByStatus + '}';
    }
    
}
