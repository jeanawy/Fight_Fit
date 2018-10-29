package th.fight.fit.mpybackoffice.domain;

import java.util.Date;

/**
 *
 * @author Panaporn
 */
public class PckUserLogin {

    private String uid;
    private String token;
    private String mobileIndexMenu;
    private String bosIndexMenu;
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;
    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public String getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }

    public String getMobileIndexMenu() {
        return mobileIndexMenu;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMobileIndexMenu(String mobileIndexMenu) {
        this.mobileIndexMenu = mobileIndexMenu;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getBosIndexMenu() {
        return bosIndexMenu;
    }

    public void setBosIndexMenu(String bosIndexMenu) {
        this.bosIndexMenu = bosIndexMenu;
    }

    @Override
    public String toString() {
        return "{" + "uid=" + uid + ", token=" + token + ", mobileIndexMenu=" + mobileIndexMenu + ", bosIndexMenu=" + bosIndexMenu + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + ", dateStr=" + dateStr + '}';
    }

}
