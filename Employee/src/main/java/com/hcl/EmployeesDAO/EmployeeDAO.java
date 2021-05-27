package com.hcl.EmployeesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hcl.employees.beans.Employee;
import com.hcl.employees.util.*;

public class EmployeeDAO {
	public static Employee addEmployee(Employee employee) throws UserInputException {
		Connection con=MysqlConnection.getConnection();
		PreparedStatement pstmt=null;
		try {
			if(!searchById(employee.getEmp_id())) {
				String sql="insert into Employee values(?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, employee.getEmp_id());
				pstmt.setString(2,employee.getEmp_name());
				pstmt.setString(3,employee.getEmp_address());
				pstmt.executeUpdate();
			}
			else
			{
				throw new UserInputException("Employee id already exsits");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	public static void updateEmployee(Employee employee) throws UserInputException {
		Connection con=MysqlConnection.getConnection();
		PreparedStatement pstmt=null;
		try {
			if(searchById(employee.getEmp_id())) {
			String sql="update employee set emp_address=? where emp_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,employee.getEmp_address());
			pstmt.setInt(2,employee.getEmp_id());
			pstmt.executeUpdate();
			}else {
				throw new UserInputException("Employee id doesn't  exsits");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteEmployee(int emp_id) throws UserInputException {
		Connection con=MysqlConnection.getConnection();
		PreparedStatement pstmt=null;
		try {
			if(searchById(emp_id)) {
				String sql="delete from employee where emp_id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,emp_id);
				pstmt.executeUpdate();
				pstmt.close();
			}
			else {
				throw new UserInputException("Employee id doesn't  exsits");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static List<Employee> searchEmployee(int emp_id) throws UserInputException{
		List<Employee> ls=new ArrayList();
		Connection con=MysqlConnection.getConnection();
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			if(searchById(emp_id)) {
	            String sql="select emp_id,emp_name, emp_address from employee where emp_id=?";
	            stmt=con.prepareStatement(sql);
	            stmt.setInt(1, emp_id);
	            rs=stmt.executeQuery();
	            while(rs.next()) {
	               
	                emp_id=rs.getInt(1);
	                String emp_name=rs.getString(2);
	                String emp_address=rs.getString(3);
	                Employee e1=new Employee();
	                e1.setEmp_id(emp_id);
	                e1.setEmp_name(emp_name);
	                e1.setEmp_address(emp_address);
	                ls.add(e1);
	               
	                }
	            }else {
	                throw new UserInputException("Employee id doesn't  exsits");
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ls;	
	}
	public static List<Employee> displayEmployee() {
		Connection con=MysqlConnection.getConnection();
		List<Employee> ls=new ArrayList();
		try {
			Statement stmt=con.createStatement();
			String sql="select emp_id,emp_name,emp_address from employee";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Employee emp = new Employee();
	            int id=rs.getInt("emp_id");
	            String name=rs.getString("emp_name");
	            String address=rs.getString("emp_address");
	            emp.setEmp_id(id);
	            emp.setEmp_name(name);
	            emp.setEmp_address(address);
	            ls.add(emp);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	public static boolean searchById(int id)
    {
		Connection con=MysqlConnection.getConnection();
        PreparedStatement ps=null;   
         try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM employee WHERE emp_id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            int n = 0;
            while ( rs.next() ) {
                n = rs.getInt(1);
            }
            if ( n > 0 ) {
               return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false; 
    }

}
