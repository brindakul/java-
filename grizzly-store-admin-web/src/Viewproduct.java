
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
public class Viewproduct extends HttpServlet {
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
			 String sql="SELECT * FROM product where name=?";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 System.out.println("query");
			 stmt.setString(1, n);
			 ResultSet rs = stmt.executeQuery();
			
			 List<Prod1data> prods1 =new ArrayList<Prod1data>();

			 if(rs.next())
			 {
				 String name=rs.getString(3);
			 String description=rs.getString(4);
				 String price=rs.getString(5);
				 String brand=rs.getString(7);
			 System.out.println(name);
			 Prod1data e=new Prod1data(); 
			 e.setName(name);
			
			 e.setBrand(brand);
			 e.setDescription(description);
			 e.setPrice(price);
			 prods1.add(e);
			
			 }
			 req.setAttribute("prods",prods1);
			 req.getRequestDispatcher("/viewproduct.jsp").forward(req,res); 
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