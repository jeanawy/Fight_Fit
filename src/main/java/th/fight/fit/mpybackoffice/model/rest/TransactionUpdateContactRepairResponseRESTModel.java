/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest;

/**
 *
 * @author Sukrit_p
 */
public class TransactionUpdateContactRepairResponseRESTModel {

 private String transactionID;
    private String transactionDateTime;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    @Override
    public String toString() {
        return "{" + "transactionID=" + transactionID + ", transactionDateTime=" + transactionDateTime + '}';
    }

}
