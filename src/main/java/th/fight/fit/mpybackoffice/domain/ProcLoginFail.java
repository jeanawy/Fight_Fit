package th.fight.fit.mpybackoffice.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ProcLoginFail implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 8422094814182280267L;

	private BigInteger sidFail;
	private String username;
	private Date loginTime;
	private String channelType;
	private String deviceId;
	private String telephone;
	private String ipAddress;

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
	public BigInteger getSidFail() {
		return sidFail;
	}
	public void setSidFail(BigInteger sidFail) {
		this.sidFail = sidFail;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
