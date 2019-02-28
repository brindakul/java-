package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import aboutprod.Prod1data;
public class Vendordao {
	
	public int validate(String un,String pw)
	{
		boolean status=false;
		int flag=0;
		try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
		 System.out.println("connection success");
PreparedStatement stmt = conn.prepareStatement("SELECT user,pass FROM vendor where user=? and pass=?");
        stmt.setString(1,un);
        stmt.setString(2, pw);
        
        ResultSet rs = stmt.executeQuery();
        status=rs.next();
        System.out.println(status);
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
		if(status)
			return 1;
		else
		{ flag++;
			return 2;
		}
	}
	public List<Prod1data> view()
	{   		 List<Prod1data> prods1 =new ArrayList<Prod1data>();

		try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
		 
		 String sql="SELECT prod_id,name,brand,category,rating FROM product";
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 ResultSet rs = stmt.executeQuery();
		 System.out.println("could connect");
		 
		 while(rs.next())
		 {
			 int id=rs.getInt(1);
		 String name=rs.getString(2);
		 String brand=rs.getString(3);
		 String category=rs.getString(4);
		 int rating=rs.getInt(5);
		// System.out.println(name);
		 Prod1data e=new Prod1data(); 
		 e.setName(name);
		e.setId(id);
		 e.setBrand(brand);
		 e.setCategory(category);
		 e.setRating(rating);
		 prods1.add(e);
		
		 }
		 rs.close();
	     stmt.close();
	     conn.close();
		
//		 req.setAttribute("prods",prods1);
//		 
//			 req.getRequestDispatcher("/listproduct.jsp").forward(req,res); 
		 
		    
     
     
	 }
	 catch(SQLException se) {
     //Handle errors for JDBC
     se.printStackTrace();
  } catch(Exception e) {
     //Handle errors for Class.forName
     e.printStackTrace();
  }
	return prods1;	
	}
	public void add()
	{
		
	}
}
	
