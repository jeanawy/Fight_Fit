package th.fight.fit.mpybackoffice.domain;

import java.math.BigInteger;
import java.util.Date;

public class PckMenu {

	private BigInteger menuId;
	private String menuCode;
    private String menuNameTh;
    private String menuNameEn;
    private String menuType;
	private String menuParentCode;
	private int priority;
	private String status;
	private int version;
	private Date createDate;
	private String createBy;
	private Date updateDttm;
	private String updateBy;
	
	public BigInteger getMenuId() {
		return menuId;
	}
	public void setMenuId(BigInteger menuId) {
		this.menuId = menuId;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuNameTh() {
		return menuNameTh;
	}
	public void setMenuNameTh(String menuNameTh) {
		this.menuNameTh = menuNameTh;
	}
	public String getMenuNameEn() {
		return menuNameEn;
	}
	public void setMenuNameEn(String menuNameEn) {
		this.menuNameEn = menuNameEn;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuParentCode() {
		return menuParentCode;
	}
	public void setMenuParentCode(String menuParentCode) {
		this.menuParentCode = menuParentCode;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
