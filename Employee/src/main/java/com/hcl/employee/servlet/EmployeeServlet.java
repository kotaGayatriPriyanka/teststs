package com.hcl.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.employees.beans.Employee;
import com.hcl.employees.services.EmployeeServices;
import com.hcl.employees.util.UserInputException;
@WebServlet("/addEmployee")

public class EmployeeServlet extends HttpServlet{
	public void init() throws ServletException {
        // Do required initialization
        System.out.println("servelt method intialized...............");
     }
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
       String emp_id=request.getParameter("id");
       String emp_name=request.getParameter("firstname");
       String emp_address=request.getParameter("address");
    
       Employee e=new Employee();
       e.setEmp_id(Integer.parseInt(emp_id));
       e.setEmp_name(emp_name);
       e.setEmp_address(emp_address);
      
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       EmployeeServices ed=new EmployeeServices();
       try {
           ed.addEmployee(e);
           //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
           //request.setAttribute("message", "Reastuarent added successfully");
          // rd.forward(request, response);
           //out.print("<html><body>added "+emp_id+"</body></html>");
           
           List<Employee> list=new ArrayList<Employee>();
           list=ed.displayEmployee();
           
           RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
           request.setAttribute("list", list);
           rd.forward(request, response);
       } catch (UserInputException e1) {
           // TODO Auto-generated catch block
           //System.out.println(e1.getMessage());
    	   //out.print("<html><body><p style='color:red;'>"+e1.getMessage()+"</body></html>");
    	   RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
    	   request.setAttribute("message",e1.getMessage());
    	   rd.forward(request, response);
       }
   
          }
	 public void destroy() {
         System.out.println("servlet is destroyed..........."); 
       }

}
