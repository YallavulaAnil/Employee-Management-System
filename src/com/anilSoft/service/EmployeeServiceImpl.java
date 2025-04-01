package com.anilSoft.service;

import com.anilSoft.beans.Employee;

import com.anilSoft.dao.EmployeeDao;
import com.anilSoft.factory.EmployeeDaoFactory;


public class EmployeeServiceImpl implements EmployeeService{
	EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
	@Override
	public String addEmployee(Employee employee) {
		String status = employeeDao.add(employee);
		return status;
	}
	@Override
	public Employee searchEmployee(int eno) {
		Employee employee = employeeDao.search(eno);
		return employee;
	}
	@Override
	public String updateEmployee(Employee employee) {
		String status = employeeDao.update(employee);
		return status;
	}
	@Override
	public String deleteEmployee(int eno) {
		String status = employeeDao.delete(eno);
		return status;
	}
}
