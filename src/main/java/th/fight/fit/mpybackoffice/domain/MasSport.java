/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.fight.fit.mpybackoffice.domain;

import java.util.Date;

/**
 *
 * @author Sent
 */
public class MasSport {
     private String sportId;
    private String sportName;
    private String sportType;
    private String urlSportPicture;
    private String isDelete;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;

    public String getSportId() {
        return sportId;
    }

    public void setSportId(String sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getUrlSportPicture() {
        return urlSportPicture;
    }

    public void setUrlSportPicture(String urlSportPicture) {
        this.urlSportPicture = urlSportPicture;
    }



    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "MasSport{" + "sportId=" + sportId + ", sportName=" + sportName + ", sportType=" + sportType + ", urlSportPicture=" + urlSportPicture  + ", isDelete=" + isDelete + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + '}';
    }
    
    
}
