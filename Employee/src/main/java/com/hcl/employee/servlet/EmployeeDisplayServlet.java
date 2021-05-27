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
@WebServlet("/displayEmployeeDetails")

public class EmployeeDisplayServlet extends HttpServlet{
	public void init() throws ServletException {
        // Do required initialization
        System.out.println("servelt method intialized...............");
     }
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
     
      
	   EmployeeServices ed=new EmployeeServices();
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       
       List<Employee> list=new ArrayList<Employee>();
       list=ed.displayEmployee();
       
       RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
       request.setAttribute("list", list);
       rd.forward(request, response);
       /*out.print("<html><body>");
       out.print("<table border='5' cellspacing='0' cellpadding='10'>");
       for(Employee e1:list) {
    	   out.print("<tr><td>"+e1.getEmp_id()+"</td><td>"+e1.getEmp_name()+"</td><td>"+e1.getEmp_address()+"</td></tr>");
    	   
       }
       out.print("</table>");
       out.print("</body></html>");*/
          }
	 public void destroy() {
         System.out.println("servlet is destroyed..........."); 
       }

}

