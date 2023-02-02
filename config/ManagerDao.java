package dao;

import entity.Manager;

public interface ManagerDao {
	public boolean register(Manager m);
	public void view(int id);
	public boolean updateName(int id,String name);
	public boolean updateDept(int id,String dept);
	public boolean updateSalary(int id,int salary);
	public void viewAllEmployees();
}
