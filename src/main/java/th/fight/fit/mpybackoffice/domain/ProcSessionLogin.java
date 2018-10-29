package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

public class ProcSessionLogin {

	private BigInteger sid;
	private String username;
	private Date loginTime;
	private Date logoutTime;
	private String ipAddress;
	
	public BigInteger getSid() {
		return sid;
	}
	public void setSid(BigInteger sid) {
		this.sid = sid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}
