import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import admininfo.Admin1data;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
public class Admin extends HttpServlet {
	boolean status=false;
	int flag=0;
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();  
    
    String un=req.getParameter("un");  
    String pw=req.getParameter("pw"); 
    HttpSession session = req.getSession();
   


    Admin1data obj=new Admin1data();
    obj.setUser(un);
    obj.setPass(pw);
    
    session.setAttribute("user", obj.getUser());
    
	 String jdbc1="com.mysql.jdbc.Driver";
	 String url="jdbc:mysql://localhost/test";
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
		 PreparedStatement stmt = conn.prepareStatement("SELECT un,pw FROM admin where un=? and pw=?");
         stmt.setString(1,un);
         stmt.setString(2, pw);
         
         ResultSet rs = stmt.executeQuery();
         status=rs.next();
         System.out.println("connection successful");
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
	 req.setAttribute("un",un);
	 if(status)
	 {
		 //req.getRequestDispatcher("/main.jsp").forward(req,res); 
	 req.getRequestDispatcher("/home.jsp").forward(req,res); 
//		 req.getRequestDispatcher("/listproduct.jsp").forward(req,res); 
//		 req.getRequestDispatcher("/viewproduct.jsp").forward(req,res); 
//		 req.getRequestDispatcher("/addproduct.jsp").forward(req,res); 
	 }
	 else
	 {
		 out.print("Enter again");
		 flag++;
		 RequestDispatcher rd=req.getRequestDispatcher("/index.html");
		 rd.include(req, res);
		 try{ 
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
	     Statement st=conn.createStatement();
	     String sql="Insert into admin(status)"+"values(flag)";
	     st.executeUpdate(sql);
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
}
