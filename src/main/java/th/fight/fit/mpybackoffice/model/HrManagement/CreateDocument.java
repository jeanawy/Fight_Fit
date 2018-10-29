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
public class CreateDocument {

    private String documentNameTh;
    private String documentNameEn;
    private String documentUrl;
    private String processDay;

    public String getDocumentNameTh() {
        return documentNameTh;
    }

    public void setDocumentNameTh(String documentNameTh) {
        this.documentNameTh = documentNameTh;
    }

    public String getDocumentNameEn() {
        return documentNameEn;
    }

    public void setDocumentNameEn(String documentNameEn) {
        this.documentNameEn = documentNameEn;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public String getProcessDay() {
        return processDay;
    }

    public void setProcessDay(String processDay) {
        this.processDay = processDay;
    }

    @Override
    public String toString() {
        return "CreateDocument{" + "documentNameTh=" + documentNameTh + ", documentNameEn=" + documentNameEn + ", documentUrl=" + documentUrl + ", processDay=" + processDay + '}';
    }
}
