package com.hcl.employees.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	private final static String url="jdbc:mysql://localhost:3306/jdbcexample";
	private final static String username="root";
	private final static String password="gayatri";
	private MysqlConnection() {
		
	}
	private static Connection con=null;
	public static Connection getConnection() {		
		try{  
			 if(con== null)
			 {
				 Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection(url,username,password);  
			 }
			}catch(Exception e){ System.out.println(e);}
		return con;  
	}

}
