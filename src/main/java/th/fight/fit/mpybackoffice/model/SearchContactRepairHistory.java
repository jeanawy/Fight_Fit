/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model;

import java.util.Date;

/**
 *
 * @author Jeep_
 */
public class SearchContactRepairHistory {

    private String buildingID;
    private String searchDateTime;
    private String statusID;

   

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public String getSearchDateTime() {
        return searchDateTime;
    }

    public void setSearchDateTime(String searchDateTime) {
        this.searchDateTime = searchDateTime;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

     @Override
    public String toString() {
        return "SearchContactRepairHistory{" + "buildingID=" + buildingID + ", searchDateTime=" + searchDateTime + ", statusID=" + statusID + '}';
    }


}
