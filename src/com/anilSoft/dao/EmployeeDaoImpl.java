package com.anilSoft.dao;

import com.anilSoft.beans.Employee;
import com.anilSoft.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao{
	
	@Override
	public String add(Employee employee) {
		String status = "";
		try{
				Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();
				int rowCount = statement.executeUpdate("insert into emp1 values("+employee.getEno()+",'"+employee.getEname()+"',"+employee.getEsal()+",'"+employee.getEaddr()+"')");
				if(rowCount == 1) {
					status = "SUCCESS";
				}else {
					status = "FAILURE";
				}
				
			
		}catch(Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public Employee search(int eno) {
		Employee employee = null;
		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp1 where eno="+eno);
			boolean b = resultSet.next();
			if(b == true) {
				employee = new Employee();
				employee.setEno(resultSet.getInt("ENO"));
				employee.setEname(resultSet.getString("ENAME"));
				employee.setEsal(resultSet.getInt("ESAL"));
				employee.setEaddr(resultSet.getString("EADDR"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	@Override
	public String update(Employee employee) {
		String status = "";
		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			int rowCount = statement.executeUpdate("update emp1 set ENAME='"+employee.getEname()+"', ESAL ="+employee.getEsal()+", EADDR ='"+employee.getEaddr()+"'where ENO ="+employee.getEno());
			if(rowCount ==1) {
				status = "SUCCESS";
			}else {
				status = "FAILURE";
			}
		}catch(Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public String delete(int eno) {
		String status = "";
		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			int rowCount = statement.executeUpdate("delete from emp1 where eno="+eno);
			if(rowCount ==1) {
				status = "SUCCESS";
			}else {
				status = "FAILURE";
			}
		}catch(Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}
		return status;
	}
}
