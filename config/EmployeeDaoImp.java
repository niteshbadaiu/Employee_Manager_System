package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import config.Helper;
import dao.EmployeeDao;
import entity.Employee;
import main.App;

public class EmployeeDaoImp implements EmployeeDao{
	Scanner sc=new Scanner(System.in);

	@Override
	public boolean register(Employee emp) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			Connection conn=Helper.createConnection();
			String query="insert into javaproject.employee (name,dept,salary)values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getDept());
			ps.setInt(3, emp.getSalary());
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
			String query="select * from javaproject.employee where id=?";
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
			String query="update javaproject.employee set name=? where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2,id);
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
			String query="update javaproject.employee set dept=? where id=?";
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
			String query="update javaproject.employee set salary=? where id=?";
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
			App.employeeApp();
		case 5:
			System.out.println("Thank you");
			System.exit(0);
		default:
			System.out.println("Invalid input");
			break;
		}
	}

}
