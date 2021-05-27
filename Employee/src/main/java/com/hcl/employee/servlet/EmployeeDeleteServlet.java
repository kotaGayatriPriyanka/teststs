package com.hcl.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.employees.beans.Employee;
import com.hcl.employees.services.EmployeeServices;
import com.hcl.employees.util.UserInputException;
@WebServlet("/deleteEmployeeDetails")

public class EmployeeDeleteServlet extends HttpServlet{
	public void init() throws ServletException {
        // Do required initialization
        System.out.println("servelt method intialized...............");
     }
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
       String emp_id=request.getParameter("id");
       //String emp_name=request.getParameter("firstname");
       //String emp_address=request.getParameter("address");
    
       Employee e=new Employee();
      
	//e.setEmp_id(Integer.parseInt(emp_id));
       //e.setEmp_name(emp_name);
       //e.setEmp_address(emp_address);
       int x = Integer.parseInt(emp_id);
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       EmployeeServices ed=new EmployeeServices();
       
       /*try {
  	    	EmployeeServices.deleteEmployee(e);
  	    	 out.print("<html><body>deleted "+emp_id+"</body></html>");
		} catch (UserInputException e1) {
			// TODO Auto-generated catch block
			//System.out.println(e1.getMessage());
			out.print("<html><body><p style='color:red;'>"+e1.getMessage()+"</body></html>");

		}*/
       try {
           EmployeeServices.deleteEmployee(x);
           RequestDispatcher rd = request.getRequestDispatcher("displayEmployeeDetails");
           request.setAttribute("message","Delete Successfully" );
           rd.forward(request, response);
           //response.sendRedirect("displayEmployeeDetails");
       } catch (UserInputException e1) {
           RequestDispatcher rd = request.getRequestDispatcher("failure.jsp");
           request.setAttribute("message","Employee Id doesnot exists" );
           rd.forward(request, response);
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
        
   
          }
	 public void destroy() {
         System.out.println("servlet is destroyed..........."); 
       }
}
