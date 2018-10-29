/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

public class PckFavourite {

    private String uid;
    private BigInteger seq;
    private String FavouriteUid;
    private String isDelete;
    private Date CreateDate;
    private String CreateBy;
    private Date UpdateDate;
    private String UpdateBy;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public BigInteger getSeq() {
        return seq;
    }

    public void setSeq(BigInteger seq) {
        this.seq = seq;
    }

    public String getFavouriteUid() {
        return FavouriteUid;
    }

    public void setFavouriteUid(String FavouriteUid) {
        this.FavouriteUid = FavouriteUid;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String CreateBy) {
        this.CreateBy = CreateBy;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date UpdateDate) {
        this.UpdateDate = UpdateDate;
    }

    public String getUpdateBy() {
        return UpdateBy;
    }

    public void setUpdateBy(String UpdateBy) {
        this.UpdateBy = UpdateBy;
    }

}
