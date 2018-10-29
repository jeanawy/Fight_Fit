/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.ws.mpyBackend.vo;

/**
 *
 * @author Anuwat_K
 */
public class BaseResponseVO {

    private String responseStatus;
    private String errorMessage;
    private String errorCode;

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "{" + "responseStatus=" + responseStatus + ", errorMessage=" + errorMessage + ", errorCode=" + errorCode + '}';
    }

}
