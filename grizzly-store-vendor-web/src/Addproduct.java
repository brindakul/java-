import dao.Vendordao;
import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.*;
import aboutprod.Prod1data;
import java.util.ArrayList;
import java.util.List;
import dao.Vendordao;
//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
public class Addproduct extends HttpServlet {
	Vendordao obj=new Vendordao();
		public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
			 String n=req.getParameter("name");  
			 int n1=Integer.parseInt(n);
			// System.out.println(obj.save(n1));
			if((obj.save(n1))==1)
			{ 
				//  req.setAttribute("vend1", vend1);
		
				//obj.vendorview(n1);
				req.getRequestDispatcher("vendordisplay").include(req,res); 
			}
}
}
