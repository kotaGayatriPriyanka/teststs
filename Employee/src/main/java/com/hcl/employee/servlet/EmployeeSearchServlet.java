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
@WebServlet("/searchEmployeeDetails")

public class EmployeeSearchServlet extends HttpServlet{
	public void init() throws ServletException {
        // Do required initialization
        System.out.println("servelt method intialized...............");
     }
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
       String emp_id=request.getParameter("id");
      // String emp_name=request.getParameter("firstname");
      // String emp_address=request.getParameter("address");
    
       Employee e=new Employee();
       e.setEmp_id(Integer.parseInt(emp_id));
       //e.setEmp_name(emp_name);
       //e.setEmp_address(emp_address);
      
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       EmployeeServices ed=new EmployeeServices();
       try {
           List<Employee>  list = new ArrayList<Employee>();
           list = EmployeeServices.searchEmployee(e.getEmp_id());
           RequestDispatcher rd = request.getRequestDispatcher("listsucces.jsp");
           request.setAttribute("list", list );
           rd.forward(request, response);
       } catch (UserInputException e2) {
           
           // TODO Auto-generated catch block
    	   RequestDispatcher rd = request.getRequestDispatcher("failure.jsp");
           request.setAttribute("message","Employee Id doesnot exists" );
           rd.forward(request, response);
           // TODO Auto-generated catch block
           e2.printStackTrace();
       }
       
       try {
           List<Employee> emp = EmployeeServices.searchEmployee(e.getEmp_id());
           for(Employee a:emp)
               out.print(a+"<br>");
           out.println("<html><body>Searching done</body></html>");    
       } catch (UserInputException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
   }
	 public void destroy() {
         System.out.println("servlet is destroyed..........."); 
       }
}

