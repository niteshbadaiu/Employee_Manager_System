package entity;

public class Login {
	String uname;
	String pass;
	public Login(String uname, String pass) {
		super();
		this.uname = uname;
		this.pass = pass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
