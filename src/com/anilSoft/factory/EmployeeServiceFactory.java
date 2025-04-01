package com.anilSoft.factory;

import com.anilSoft.service.EmployeeService;
import com.anilSoft.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeService employeeService;
	static {
		employeeService  = new EmployeeServiceImpl();
	}
	public static EmployeeService getEmployeeService() {
		return employeeService;
	}
	
}
