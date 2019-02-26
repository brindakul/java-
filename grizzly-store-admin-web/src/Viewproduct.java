import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.*;


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
	   
		out.print("hello");
		String name1=(String) req.getAttribute("name");
		out.print(name1);
//		 try
//		 {
//			 Class.forName("com.mysql.jdbc.Driver");
//			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
//			 
//			 String sql="SELECT description FROM product where name= ";
//			 PreparedStatement stmt = conn.prepareStatement(sql);
//			 
//			 ResultSet rs = stmt.executeQuery();
//			// System.out.println("could connect");
}
}