package entidades;

public class usuario {
	
	/*usuario char(6) primary key,
    pass char(30)*/
	
	private String user; 
	private String pass;

	public usuario(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public usuario() {
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
	
