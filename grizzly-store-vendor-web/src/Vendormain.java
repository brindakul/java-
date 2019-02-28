
import dao.Vendordao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import aboutprod.Prod1data;

@WebServlet("/Vendormain")
public class Vendormain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Vendordao obj=new Vendordao();
	List<Prod1data> prods1= new ArrayList<Prod1data>();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();  
	    out.print("hello");
	    String un=req.getParameter("un");  
	    String pw=req.getParameter("pw"); 
	    out.print(un+pw);
	    HttpSession session = req.getSession();
	    out.print(obj.validate(un, pw));
	 
			if((obj.validate(un, pw))==1)
					{
				  prods1=obj.view();
				  req.setAttribute("prods",prods1);
				req.getRequestDispatcher("/main.jsp").forward(req,res); 
					}
		
	    
	}
}


