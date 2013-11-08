package servlet;

import hibernateAccesObject.Factory;
import hibernateMappingClass.User;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class JaasLoginModule implements LoginModule {

	private String name = null;
	private String pass = null;
	private Subject subject = null;
	private CallbackHandler callbackHandler = null;
	
	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		
		UserNamePrincipal usrPr	= new UserNamePrincipal(this.name);
		subject.getPrincipals().add(usrPr);
		User user=Factory.getInstance().getUserHAO().getUserByMail(this.name);
		String group="guest";
		if (user != null){
			if (user.getPrivileged()==0){
				group="admin";
			}
			if (user.getPrivileged()==1){
				group="member";
			}
			if (user.getPrivileged()==2){
				group="blockMember";
			}
			System.out.println(group);
		}
		UserGroupPrincipal usrGr = new UserGroupPrincipal(group);
		subject.getPrincipals().add(usrGr);
		
		return true;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> arg2, Map<String, ?> arg3) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
	}

	@Override
	public boolean login() throws LoginException {
		NameCallback nameCallback = new NameCallback("Name");
		PasswordCallback passwordCallback = new PasswordCallback("Password", false);
		
		Callback[] callback = new Callback[] { nameCallback, passwordCallback };
		try {
			callbackHandler.handle(callback);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
		}
		
		User user = Factory.getInstance().getUserHAO().getUserByMail(nameCallback.getName());
		if (user == null)
			throw new LoginException();
		
		System.out.println(passwordCallback.getPassword().length);
		System.out.println(user.getHashPass().length());
		
		String string = new String(passwordCallback.getPassword());
		System.out.println(user.getHashPass() + " == " + string);
		if (user.getHashPass().equals(string)) {
			this.name = nameCallback.getName();
			this.pass = String.valueOf(passwordCallback.getPassword());
		}
		else
			throw new LoginException();	
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		return false;
	}

}
