package aboutprod;
import java.util.*;  
import java.sql.*;  
public class ProdDao {
	
	    public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","password-1");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save (Prod1data e){  
	        int status=0;  
	        try{  
	            Connection con=ProdDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into product(prod_id,category,name,description,price,brand,rating) values (?,?,?,?,?,?,?)");  
	            ps.setInt(1,e.getId());  
	            ps.setString(2,e.getCategory());  
	            ps.setString(3,e.getName());  
	            ps.setString(4,e.getDescription());  
	            ps.setString(5,e.getPrice());  
	            ps.setString(6,e.getBrand());  
	            ps.setInt(7,e.getRating());  
	            status=ps.executeUpdate();  
	              System.out.println("record inserted");
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	   
}
