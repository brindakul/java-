package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import aboutprod.Prod1data;
import data.Vendor2data;
import data.Inventory1data;
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
	public static int save (int id){  
		        int status=0;
		        Prod1data e=new Prod1data();
		        try{  
		            Class.forName("com.mysql.jdbc.Driver");  
		          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");  
		           System.out.println("connection done");
		            PreparedStatement ps=con.prepareStatement(  
		                         "insert into vendor1(id) values (?)");  
		            ps.setInt(1,id);  
		          //  System.out.println(id);
		            status=ps.executeUpdate();  
		              System.out.println("record inserted");
		            con.close();  
		        }catch(Exception ex){ex.printStackTrace();}  
		          
		        return status;  
		    } 
	public static List<Inventory1data> vendorview()
	{
//		 List<Prod1data> prods1 =new ArrayList<Prod1data>();
		 List<Inventory1data> vend1 =new ArrayList<Inventory1data>();
			try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");
			 
			 String sql="SELECT p.name,v.id,v.stock,v.req,v.buffer,p.price,p.rating FROM product p,vendor1 v where p.prod_id=v.id";
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 
			 ResultSet rs = stmt.executeQuery();
			 System.out.println("could connect");
			 
			 while(rs.next())
			 {
				
			 String name=rs.getString(1);
			 int id1=rs.getInt(2);
			 int stock=rs.getInt(3);
			 int req=rs.getInt(4);
			 int buffer=rs.getInt(5);
			 String price=rs.getString(6);
			 int rating=rs.getInt(7);
			// System.out.println(name);
//			 Prod1data e=new Prod1data(); 
			Inventory1data v=new Inventory1data();
			 v.setName(name);
			v.setId(id1);
			v.setId(id1);
			
			 v.setStock(stock);
			 v.setReq(req);
			 v.setBuffer(buffer);
			 v.setPrice(price);
			 v.setRating(rating);
			
			vend1.add(v);
			 }
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
			return vend1;
	}
	public int enter(String un,int flag)
	{
		 int status=0;
	        Prod1data e=new Prod1data();
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");  
	           System.out.println("connection done");
	            PreparedStatement ps=con.prepareStatement(  
	                         "UPDATE vendor " +
                   "SET status=? WHERE user=?"); 
	            ps.setInt(1, flag);
	            ps.setString(2,un);  
	          //  System.out.println(id);
	            status=ps.executeUpdate();  
	              System.out.println("record inserted");
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	}
}
	
		    
	

	
