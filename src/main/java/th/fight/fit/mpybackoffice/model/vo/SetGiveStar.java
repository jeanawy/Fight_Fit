/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.vo;

/**
 *
 * @author ธนากร
 */
public class SetGiveStar {

    private String groupUserID;
    private String department;
    private String division;
    private String searchName;
    private String giveGoldStar;
    private String giveSilverStar;
    private String giveBronzeStar;

    public String getGroupUserID() {
        return groupUserID;
    }

    public void setGroupUserID(String groupUserID) {
        this.groupUserID = groupUserID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getGiveGoldStar() {
        return giveGoldStar;
    }

    public void setGiveGoldStar(String giveGoldStar) {
        this.giveGoldStar = giveGoldStar;
    }

    public String getGiveSilverStar() {
        return giveSilverStar;
    }

    public void setGiveSilverStar(String giveSilverStar) {
        this.giveSilverStar = giveSilverStar;
    }

    public String getGiveBronzeStar() {
        return giveBronzeStar;
    }

    public void setGiveBronzeStar(String giveBronzeStar) {
        this.giveBronzeStar = giveBronzeStar;
    }

    @Override
    public String toString() {
        return "SetGiveStar{" + "group=" + groupUserID + ", department=" + department + ", division=" + division + ", searchName=" + searchName + ", giveGoldStar=" + giveGoldStar + ", giveSilverStar=" + giveSilverStar + ", giveBronzeStar=" + giveBronzeStar + '}';
    }

}
