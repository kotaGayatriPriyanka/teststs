package com.hcl.employees.services;

import java.util.List;

import com.hcl.EmployeesDAO.EmployeeDAO;
import com.hcl.employees.beans.Employee;
import com.hcl.employees.util.UserInputException;

public class EmployeeServices {
	public static List<Employee> displayEmployee(){
		return EmployeeDAO.displayEmployee();
	}

	public static Employee addEmployee(Employee employee) throws UserInputException {
		// TODO Auto-generated method stub
		return EmployeeDAO.addEmployee(employee);
	}
	public static void updateEmployee(Employee employee) throws UserInputException{
		 EmployeeDAO.updateEmployee(employee);
	}
	public static void deleteEmployee(int emp_id) throws UserInputException {
		EmployeeDAO.deleteEmployee(emp_id);
		
	}
	public static List<Employee> searchEmployee(int emp_id) throws UserInputException{
		return EmployeeDAO.searchEmployee(emp_id);
	}

}
