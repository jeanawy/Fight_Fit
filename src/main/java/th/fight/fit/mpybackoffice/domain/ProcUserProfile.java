package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

public class ProcUserProfile {

	private BigInteger userId;
	private String nameTh;
	private String nameEn;
	private String fullNameTh;
	private String fullNameEn;
	private String surnameTh;
	private String surnameEn;
	private String citizenId;
	private String passportId;
	private String sex;
	private String email;
	private String mobileNumber;
	private String status;
	private Date createDate;
	private String createBy;
	private Date upDateDttm;
	private Date updateDate;
	private String updateBy;
	
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getNameTh() {
		return nameTh;
	}
	public void setNameTh(String nameTh) {
		this.nameTh = nameTh;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getFullNameTh() {
		return fullNameTh;
	}
	public void setFullNameTh(String fullNameTh) {
		this.fullNameTh = fullNameTh;
	}
	public String getFullNameEn() {
		return fullNameEn;
	}
	public void setFullNameEn(String fullNameEn) {
		this.fullNameEn = fullNameEn;
	}
	public String getSurnameTh() {
		return surnameTh;
	}
	public void setSurnameTh(String surnameTh) {
		this.surnameTh = surnameTh;
	}
	public String getSurnameEn() {
		return surnameEn;
	}
	public void setSurnameEn(String surnameEn) {
		this.surnameEn = surnameEn;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
