/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.exception;

/**
 *
 * @author Anuwat_K
 */
public class ServiceValidation extends Exception {

    public ServiceValidation() {
    }

    public ServiceValidation(String message) {
        super(message);
    }

    public ServiceValidation(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceValidation(Throwable cause) {
        super(cause);
    }

    public ServiceValidation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
