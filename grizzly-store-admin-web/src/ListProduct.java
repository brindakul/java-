
import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import aboutprod.Prod1data;
public class ListProduct extends HttpServlet {
	boolean status=false;
	int flag=0;
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();  
   
	out.print("hello");
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
		 
		 String sql="SELECT name,brand,category,rating FROM product";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 ResultSet rs = stmt.executeQuery();
		 System.out.println("could connect");
		 
		 List<Prod1data> prods1 =new ArrayList<Prod1data>();
		 while(rs.next())
		 {
			 
		 String name=rs.getString(1);
		 String brand=rs.getString(2);
		 String category=rs.getString(3);
		 int rating=rs.getInt(4);
		// System.out.println(name);
		 Prod1data e=new Prod1data(); 
		 e.setName(name);
		
		 e.setBrand(brand);
		 e.setCategory(category);
		 e.setRating(rating);
		 prods1.add(e);
		
		 }
		 req.setAttribute("prods",prods1);
		 
			 req.getRequestDispatcher("/listproduct.jsp").forward(req,res); 
		 
		    
      
      rs.close();
      stmt.close();
      conn.close();
	 }
	 catch(SQLException se) {
      //Handle errors for JDBC
      se.printStackTrace();
   } catch(Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
   }
}
}