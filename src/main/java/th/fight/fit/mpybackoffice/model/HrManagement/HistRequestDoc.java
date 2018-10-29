/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.HrManagement;

/**
 *
 * @author Sukrit_p
 */
public class HistRequestDoc {

    private String requestDay;
    private String image;
    private String nameEN;
    private String divisionName;
    private String departmentName;
    private String position;
    private String documentName;
    private String documentID;
    private String buildingName;
    private String statusDoc;
    private String statusColor;
    private String tranID;
    private String uid;

    public String getRequestDay() {
        return requestDay;
    }

    public void setRequestDay(String requestDay) {
        this.requestDay = requestDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStatusDoc() {
        return statusDoc;
    }

    public void setStatusDoc(String statusDoc) {
        this.statusDoc = statusDoc;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getTranID() {
        return tranID;
    }

    public void setTranID(String tranID) {
        this.tranID = tranID;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "HistRequestDoc{" + "requestDay=" + requestDay + ", image=" + image + ", nameEN=" + nameEN + ", divisionName=" + divisionName + ", departmentName=" + departmentName + ", position=" + position + ", documentName=" + documentName + ", documentID=" + documentID + ", buildingName=" + buildingName + ", statusDoc=" + statusDoc + ", statusColor=" + statusColor + ", tranID=" + tranID + ", uid=" + uid + '}';
    }

}
