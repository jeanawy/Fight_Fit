package th.fight.fit.mpybackoffice.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import th.fight.fit.mpybackoffice.security.SecurityAuthority;

public class UserDetail implements UserDetails ,Serializable {

	private ProcUserProfile procUserProfile;
	private PckRole role;
	private List<PckFunction> functionList;
	private BigInteger userAuthenId;
	private ProcUserLogin userLogin;
	private List<PckMenu> menuList;
	private BigInteger sid;
	private String loginUsername;
	
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		for(PckFunction function : functionList){
			SecurityAuthority authority = new SecurityAuthority(function.getFuncCode());
			authorities.add(authority);

		}

		for(PckMenu menu : menuList){
			SecurityAuthority authority = new SecurityAuthority(menu.getMenuCode());
			authorities.add(authority);
			
		}
		
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public ProcUserProfile getProcUserProfile() {
		return procUserProfile;
	}
	public void setProcUserProfile(ProcUserProfile procUserProfile) {
		this.procUserProfile = procUserProfile;
	}
	public PckRole getRole() {
		return role;
	}
	public void setRole(PckRole role) {
		this.role = role;
	}
	public List<PckFunction> getFunctionList() {
		return functionList;
	}
	public void setFunctionList(List<PckFunction> functionList) {
		this.functionList = functionList;
	}
	public BigInteger getUserAuthenId() {
		return userAuthenId;
	}
	public void setUserAuthenId(BigInteger userAuthenId) {
		this.userAuthenId = userAuthenId;
	}
	public ProcUserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(ProcUserLogin userLogin) {
		this.userLogin = userLogin;
	}
	public List<PckMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<PckMenu> menuList) {
		this.menuList = menuList;
	}
	public BigInteger getSid() {
		return sid;
	}
	public void setSid(BigInteger sid) {
		this.sid = sid;
	}
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	
}
