package servlet;

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
		UserGroupPrincipal usrGr = new UserGroupPrincipal(this.pass);
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
				
		this.name = nameCallback.getName();
		this.pass = String.valueOf(passwordCallback.getPassword());
		
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		return false;
	}

}
