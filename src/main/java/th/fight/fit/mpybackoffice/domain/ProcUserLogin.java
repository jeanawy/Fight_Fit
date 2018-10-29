package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

public class ProcUserLogin {

	private BigInteger userLoginId;
	private BigInteger userId;
	private String userName;
	private String userType;
	private int counter;
	private String password;
	private Date lastLoginDttm;
	private String lastLoginIpAddress;
	private String createBy;
	private Date upDateDttm;
	private Date updateDate;
	private String updateBy;
	
	public BigInteger getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(BigInteger userLoginId) {
		this.userLoginId = userLoginId;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLoginDttm() {
		return lastLoginDttm;
	}
	public void setLastLoginDttm(Date lastLoginDttm) {
		this.lastLoginDttm = lastLoginDttm;
	}
	public String getLastLoginIpAddress() {
		return lastLoginIpAddress;
	}
	public void setLastLoginIpAddress(String lastLoginIpAddress) {
		this.lastLoginIpAddress = lastLoginIpAddress;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getUpDateDttm() {
		return upDateDttm;
	}
	public void setUpDateDttm(Date upDateDttm) {
		this.upDateDttm = upDateDttm;
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
	
}
