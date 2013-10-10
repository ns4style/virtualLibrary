package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	private String mail = null;
	private String pass = null;
	private int    priv = 0;
	
	private Subject subject = null;
	private CallbackHandler callbackHandler = null;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.24.1.172:3306/test";
	
	static final String USER = "user1";
	static final String PASS = "c$awth3b33st";
	
	static final String SQL = "select privileged, hash_pass from users where mail=? limit 1";
	
	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		
		String group = this.priv == 1 ? "admin" : "user";
		
		UserNamePrincipal usrPr	= new UserNamePrincipal(this.mail);
		subject.getPrincipals().add(usrPr);
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
				
		this.mail = nameCallback.getName();
		this.pass = String.valueOf(passwordCallback.getPassword());
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, this.mail);
			ResultSet rs = pstmt.executeQuery();
			
			if ( !rs.next() ) {
				throw new LoginException();
			}
			
			if ( this.pass.equals(rs.getString("hash_pass")) ) {
				this.priv = rs.getInt("privileged");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		throw new LoginException();
	}

	@Override
	public boolean logout() throws LoginException {
		return false;
	}

}
