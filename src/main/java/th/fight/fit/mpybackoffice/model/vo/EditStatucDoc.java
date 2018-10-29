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
public class EditStatucDoc {

    private String transcationID;
    private String transcationCode;
    private String documentID;

    public String getTranscationID() {
        return transcationID;
    }

    public void setTranscationID(String transcationID) {
        this.transcationID = transcationID;
    }

    public String getTranscationCode() {
        return transcationCode;
    }

    public void setTranscationCode(String transcationCode) {
        this.transcationCode = transcationCode;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    @Override
    public String toString() {
        return "EditStatucDoc{" + "transcationID=" + transcationID + ", transcationCode=" + transcationCode + ", documentID=" + documentID + '}';
    }

}
