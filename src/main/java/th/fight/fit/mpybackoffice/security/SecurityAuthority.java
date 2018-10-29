package th.fight.fit.mpybackoffice.security;

import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {

	private String authority;
	
	public SecurityAuthority(String authority){
		this.authority = authority;
		
	}
	
	public String getAuthority() {
		return authority;
	}

	@Override
	public int hashCode() {
		return authority.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!(obj instanceof SecurityAuthority))
			return false;
		
		return ((SecurityAuthority) obj).getAuthority().equals(authority);
		
	}

}
