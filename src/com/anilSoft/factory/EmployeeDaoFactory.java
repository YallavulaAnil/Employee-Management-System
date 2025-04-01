package com.anilSoft.factory;

import com.anilSoft.dao.EmployeeDao;
import com.anilSoft.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
	private static EmployeeDao employeeDao;
	static {
		employeeDao = new EmployeeDaoImpl();
	}
	public static EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

}
