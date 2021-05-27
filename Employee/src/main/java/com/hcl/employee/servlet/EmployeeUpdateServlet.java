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
@WebServlet("/updateEmployeeDetails")

public class EmployeeUpdateServlet extends HttpServlet{
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
      
       //List<Employee> ls=new ArrayList<>();
       //ls.add(e);
   // Set response content type
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       EmployeeServices ed=new EmployeeServices();
       
       //update
       /*try {
    	    EmployeeServices.updateEmployee(e);
    	    out.print("<html><body>updated "+emp_id+"</body></html>");
		} catch (UserInputException e1) {
			// TODO Auto-generated catch block
			//System.out.println(e1.getMessage());
			out.print("<html><body><p style='color:red;'>"+e1.getMessage()+"</body></html>");
		}
		*/
       
       try {
           EmployeeServices.updateEmployee(e);
           RequestDispatcher rd = request.getRequestDispatcher("displayEmployeeDetails");
           request.setAttribute("message","updated Successfully" );
           rd.forward(request, response);
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

