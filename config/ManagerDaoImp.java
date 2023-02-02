package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import config.Helper;
import dao.ManagerDao;
import entity.Manager;
import main.App;

public class ManagerDaoImp implements ManagerDao{
	Scanner sc=new Scanner(System.in);

	@Override
	public boolean register(Manager m) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			Connection conn=Helper.createConnection();
			String query="insert into javaproject.manager (name,dept,salary)values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, m.getName());
			ps.setString(2, m.getDept());
			ps.setInt(3, m.getSalary());
			ps.execute();
			result=true;
		}catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}

	@Override
	public void view(int id) {
		// TODO Auto-generated method stub
		try {
			Connection conn=Helper.createConnection();
			String query="select * from javaproject.manager where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("ID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Dept : "+rs.getString(3));
				System.out.println("Salary : "+rs.getInt(4));
				System.out.println("--------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean updateName(int id,String name) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			Connection conn=Helper.createConnection();
			String query="update javaproject.manager set name=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.execute();
			result=true;
		}catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}

	@Override
	public boolean updateDept(int id,String dept) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			Connection conn=Helper.createConnection();
			String query="update javaproject.manager set dept=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(2,id);
			ps.setString(1,dept);
			ps.execute();
			result=true;
		}catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}

	@Override
	public boolean updateSalary(int id,int salary) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			Connection conn=Helper.createConnection();
			String query="update javaproject.manager set salary=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(2,id);
			ps.setInt(1,salary);
			ps.execute();
			result=true;
		}catch(Exception e) {
			e.printStackTrace();
			result=false;
		}
		return result;
	}

	@Override
	public void viewAllEmployees() {
		// TODO Auto-generated method stub
		try {
			Connection conn=Helper.createConnection();
			String query="select * from javaproject.employee";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("ID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Dept : "+rs.getString(3));
				System.out.println("Salary : "+rs.getInt(4));
				System.out.println("--------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void update() {
		System.out.println("Select anyone one:\n1. Update name\n2. Update dept\n3. Update salary\n4. Back\n5. Exit\nEnter your choice");
		int updateChoice=sc.nextInt();
		switch(updateChoice) {
		case 1:
			System.out.println("Enter id:");
			int nameId=sc.nextInt();
			System.out.println("Enter new name:");
			String name=sc.next();
			if(updateName(nameId, name)) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Something went wrong");
			}
			break;
		case 2:
			System.out.println("Enter id:");
			int deptId=sc.nextInt();
			System.out.println("Enter new new dept:");
			String dept=sc.next();
			if(updateDept(deptId, dept)) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Something went wrong");
			}
			break;
		case 3:
			System.out.println("Enter id:");
			int salaryId=sc.nextInt();
			System.out.println("Enter new new salary:");
			int salary=sc.nextInt();
			if(updateSalary(salaryId, salary)) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Something went wrong");
			}
			break;
		case 4:
			App.managerApp();
			break;
		case 5:
			System.out.println("Thank you");
			System.exit(0);
		default:
			System.out.println("Invalid input");
			break;
		}
	}
	
}
