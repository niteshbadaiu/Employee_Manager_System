package dao;

import entity.Employee;

public interface EmployeeDao {
	public boolean register(Employee emp);
	public void view(int id);
	public boolean updateName(int id,String name);
	public boolean updateDept(int id,String dept);
	public boolean updateSalary(int id,int salary);
}
