package main;

import java.util.Scanner;

import dao.LoginDao;
import daoImplement.EmployeeDaoImp;
import daoImplement.LoginDaoImp;
import daoImplement.ManagerDaoImp;
import entity.Employee;
import entity.Login;
import entity.Manager;

public class App {
	public static void employeeApp() {
		Scanner sc=new Scanner(System.in);
		EmployeeDaoImp edi=new EmployeeDaoImp();
		System.out.println("Select anyone one:\n1. Register\n2. View\n3. Update\n4. Back\nEnter your choice");
		int empChoice=sc.nextInt();
		switch(empChoice) {
		case 1:
			System.out.println("Enter employee information:");
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter dept:");
			String dept=sc.next();
			System.out.println("Enter salary:");
			int salary=sc.nextInt();
			Employee emp=new Employee();
			emp.setName(name);
			emp.setDept(dept);
			emp.setSalary(salary);
			if(edi.register(emp)) {
				System.out.println("Registered successfully");
			}else {
				System.out.println("Something went wrong");
			}
			break;
		case 2:
			System.out.println("Enter id:");
			int eid=sc.nextInt();
			edi.view(eid);
			break;
		case 3:
			edi.update();
			break;
		case 4:
			break;
		}
	}
	
	public static void managerApp() {
		Scanner sc=new Scanner(System.in);
		ManagerDaoImp mdi=new ManagerDaoImp();
		System.out.println("Select anyone one:\n1. Register\n2. View\n3. Update\n4. View all employees\n5. Back\nEnter your choice");
		int manChoice=sc.nextInt();
		switch(manChoice) {
		case 1:
			System.out.println("Enter manager information:");
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter dept:");
			String dept=sc.next();
			System.out.println("Enter salary:");
			int salary=sc.nextInt();
			Manager man=new Manager();
			man.setName(name);
			man.setDept(dept);
			man.setSalary(salary);
			if(mdi.register(man)) {
				System.out.println("Registered successfully");
			}else {
				System.out.println("Something went wrong");
			}
			break;
		case 2:
			System.out.println("Enter id:");
			int mid=sc.nextInt();
			mdi.view(mid);
			break;
		case 3:
			mdi.update();
			break;
		case 4:
			mdi.viewAllEmployees();
		case 5:
			break;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome");
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		Login l=new Login();
		l.setUname(username);
		l.setPass(password);
		LoginDaoImp ldi=new LoginDaoImp();
		if(ldi.login(username, password)) {
			while(true) {
				System.out.println("Select anyone one:\n1. Employee\n2. Manager\n3. Exit\nEnter your choice");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					App.employeeApp();
					break;
				case 2:
					App.managerApp();
					break;
				case 3:
					System.out.println("Thank you");
					System.exit(0);
				}
			}
			
		}else {
			System.out.println("Invalid username or password");
		}
}
}
