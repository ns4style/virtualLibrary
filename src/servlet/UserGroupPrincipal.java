package servlet;

import java.security.Principal;

public class UserGroupPrincipal implements Principal {

	private String group;
	
	@Override
	public String getName() {
		return group;
	}
	
	public UserGroupPrincipal(String group) {
		this.group = group;
	}

}
