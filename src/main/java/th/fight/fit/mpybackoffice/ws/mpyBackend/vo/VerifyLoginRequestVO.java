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
public class VerifyLoginRequestVO {

    private String verifyOption;
    private String email;
    private String jack;

    public String getVerifyOption() {
        return verifyOption;
    }

    public void setVerifyOption(String verifyOption) {
        this.verifyOption = verifyOption;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJack() {
        return jack;
    }

    public void setJack(String jack) {
        this.jack = jack;
    }

    @Override
    public String toString() {
        return "{" + "verifyOption=" + verifyOption + ", email=" + email + ", jack=" + jack + '}';
    }

}
