
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
@WebServlet("/Vendormain")
public class Vendormain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Vendordao obj=new Vendordao();
	List<Prod1data> prods1= new ArrayList<Prod1data>();
	List<Inventory1data> vend1= new ArrayList<Inventory1data>();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	//    HttpSession session = req.getSession();
	   // out.print(obj.validate(un, pw));
	 
			
					
				  prods1=obj.view();
				vend1=obj.vendorview();
			//	System.out.println(vend1);
				  req.setAttribute("prods",prods1);
				  req.setAttribute("vend1", vend1);
				//  res.sendRedirect("/main1.jsp");
			req.getRequestDispatcher("/main1.jsp").forward(req,res); 
					
		
	    
	}
}


