import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.*;
import admininfo.Admin1data;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
public class Adminlogout extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(false);
		if(session != null){
    		session.invalidate();
    	}
  request.getRequestDispatcher("/index.jsp").forward(request, response);
}
}
