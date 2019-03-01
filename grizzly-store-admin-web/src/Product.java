

import java.io.IOException;
import java.io.PrintWriter;
import aboutprod.Prod1data;
import aboutprod.ProdDao;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class Product extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        //out.print("success");
	        String id=request.getParameter("id");
	        String name=request.getParameter("name");  
	       String category=request.getParameter("category");  
	        String description=request.getParameter("description");  
	        String price=request.getParameter("price");  
	       // String brand=request.getParameter("brand");  
	      //  String rating=request.getParameter("rating");  
	           
	        Prod1data e=new Prod1data(); 
	      //  int rating1=Integer.parseInt(rating);
	        int id1=Integer.parseInt(id);
	        e.setId(id1);
	        e.setName(name);  
	        e.setCategory(category);  
	        e.setDescription(description);  
	        e.setPrice(price);  
	      //  e.setBrand(brand);
	     //   e.setRating(rating1);
	        System.out.println("<p>Record");
	        int status=ProdDao.save(e); 
	        System.out.println("<p>Record1");
	        if(status>0){  
	        	request.getRequestDispatcher("listproduct").forward(request, response);
	        	}else{  
	        		request.getRequestDispatcher("/addproduct.jsp").forward(request, response);  
	        }  
	          
	        out.close();  
	    }  
}

