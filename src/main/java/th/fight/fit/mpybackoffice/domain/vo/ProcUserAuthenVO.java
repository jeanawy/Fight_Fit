package th.fight.fit.mpybackoffice.domain.vo;

import java.math.BigInteger;
import java.util.Date;

public class ProcUserAuthenVO {

	private BigInteger userAuthenId;
	private BigInteger userId;
	private String citizenId;
	private String passportId;
	private String roleCode;
	private Date createDate;
	private String createBy;
	private Date updateDttm;
	private String updateBy;
	
	public BigInteger getUserAuthenId() {
		return userAuthenId;
	}
	public void setUserAuthenId(BigInteger userAuthenId) {
		this.userAuthenId = userAuthenId;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
	public Date getUpdateDttm() {
		return updateDttm;
	}
	public void setUpdateDttm(Date updateDttm) {
		this.updateDttm = updateDttm;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	
}
