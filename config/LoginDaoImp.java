package daoImplement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import config.Helper;
import dao.LoginDao;

public class LoginDaoImp implements LoginDao{

	@Override
	public boolean login(String uname, String pass) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			Connection conn=Helper.createConnection();
			String query="select * from javaproject.credentials";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				String dbUname=rs.getString("username");
				String dbPass=rs.getString("password");
				if(uname.equals(dbUname) && pass.equals(dbPass)) {
					result=true;
				}else {
					result=false;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}

}
