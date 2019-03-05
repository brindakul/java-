import dao.Vendordao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import aboutprod.Prod1data;
import data.Inventory1data;
public class Vendordelete extends HttpServlet {
	Vendordao obj=new Vendordao();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();  
	   
		 String n=req.getParameter("name");  
		 int id=Integer.parseInt(n);
		 obj.delete(id);
		 req.getRequestDispatcher("vendordisplay").forward(req,res); 
	}

}
