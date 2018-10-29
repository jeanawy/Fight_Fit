package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

public class PckFunction {

	private BigInteger funcId;
	private String funcCode;
	private String funcNameTh;
	private String funcNameEn;
	private String status;
	private String type;
	private int version;
	private Date createDate;
	private String createBy;
	private Date updateDttm;
	private String updateBy;
	public BigInteger getFuncId() {
		return funcId;
	}
	public void setFuncId(BigInteger funcId) {
		this.funcId = funcId;
	}
	public String getFuncCode() {
		return funcCode;
	}
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	public String getFuncNameTh() {
		return funcNameTh;
	}
	public void setFuncNameTh(String funcNameTh) {
		this.funcNameTh = funcNameTh;
	}
	public String getFuncNameEn() {
		return funcNameEn;
	}
	public void setFuncNameEn(String funcNameEn) {
		this.funcNameEn = funcNameEn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
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

}
