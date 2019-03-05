
import dao.Vendordao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Vendorlogin")
public class Vendorlogin extends HttpServlet {
	Vendordao obj=new Vendordao();
	int flag=0;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();  
	  //  out.print("hello");
	    String un=req.getParameter("un");  
	    String pw=req.getParameter("pw"); 
	    //out.print(un+pw);
	    HttpSession session = req.getSession();
		session.setAttribute("un", un);
	    Cookie loginCookie = new Cookie("un",un);
	    loginCookie.setMaxAge(30*60);
		res.addCookie(loginCookie);
		if((obj.validate(un, pw))==1)
		{
			req.getRequestDispatcher("vendordisplay").forward(req,res); 
		}
		else
		{
			flag++;
			obj.enter(un,flag);
		
		if(flag<=3)
			req.getRequestDispatcher("/index.jsp").forward(req,res); 
			
		
		else
		{    
			 out.println("YOU HAVE BEEN LOCKED OUT");
			//req.getRequestDispatcher("vendorlogout").forward(req, res);
			session.invalidate();
			// session = req.getSession(false);
		}
	}}

	
	
}
