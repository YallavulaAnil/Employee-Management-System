package com.anilSoft.dao;

import com.anilSoft.beans.Employee;

public interface EmployeeDao {
	
	public String add(Employee employee);
	public Employee search(int eno);
	public String update(Employee employee);
	public String delete(int eno);

}
