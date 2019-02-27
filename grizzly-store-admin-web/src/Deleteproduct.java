import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.*;
import aboutprod.Prod1data;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import aboutprod.Prod1data;
public class Deleteproduct extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();  
	   
		 String n=req.getParameter("name");  
		
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
			 System.out.println("connection hppnd");
			 String sql="DELETE  FROM product where name=?";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 System.out.println("query");
			 stmt.setString(1, n);
			 	 stmt.executeUpdate();
		 }
		
		 catch(SQLException se) {
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch(Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		 req.getRequestDispatcher("/listproduct.jsp").forward(req,res); 
		 
}
	}