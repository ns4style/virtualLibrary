package servlet;

import java.security.Principal;

public class UserNamePrincipal implements Principal {

	private String name;
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public UserNamePrincipal(String name) {
		this.name = name;
	}

}
