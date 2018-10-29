/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.model.rest.UserAuthorize;

import java.util.List;

/**
 *
 * @author Panaporn
 */
public class GetUserAuthorizeRequestRestModel {

    private boolean remaindRecordFlag;
    private String index;
    private String indexTotal;
    private List<Group> request;

    public boolean isRemaindRecordFlag() {
        return remaindRecordFlag;
    }

    public void setRemaindRecordFlag(boolean remaindRecordFlag) {
        this.remaindRecordFlag = remaindRecordFlag;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndexTotal() {
        return indexTotal;
    }

    public void setIndexTotal(String indexTotal) {
        this.indexTotal = indexTotal;
    }

    public List<Group> getRequest() {
        return request;
    }

    public void setRequest(List<Group> request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "GetUserAuthorizeRequestRestModel{" + "remaindRecordFlag=" + remaindRecordFlag + ", index=" + index + ", indexTotal=" + indexTotal + ", request=" + request + '}';
    }

}
