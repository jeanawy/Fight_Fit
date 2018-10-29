package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

public class ProcUserAuthen {

	private BigInteger userAuthenId;
	private BigInteger userId;
	private String roleCode;
	private String isDelete;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDttm;
	
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
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDttm() {
		return updateDttm;
	}
	public void setUpdateDttm(Date updateDttm) {
		this.updateDttm = updateDttm;
	}
	
}
