/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.StarRewardManagement;

/**
 *
 * @author Sukrit_p
 */
public class RewardsList {

    private String reward;
    private String searchByStatus;

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getSearchByStatus() {
        return searchByStatus;
    }

    public void setSearchByStatus(String searchByStatus) {
        this.searchByStatus = searchByStatus;
    }

    @Override
    public String toString() {
        return "RewardsList{" + "reward=" + reward + ", searchByStatus=" + searchByStatus + '}';
    }

}
