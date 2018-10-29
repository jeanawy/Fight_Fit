/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.vo;

/**
 *
 * @author Sukrit_p
 */
public class RequestDocHistory {

    private String documentID;
    private String requestDay;
    private String searchByStatus;

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
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
        return "RequestDocHistory{" + "documentID=" + documentID + ", requestDay=" + requestDay + ", searchByStatus=" + searchByStatus + '}';
    }

}
