package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
public class DiskSpaceCheck {

	public static void main(String[] args) throws IOException {
          Properties prop = new Properties();
          FileInputStream in= new FileInputStream("config.properties");
      
	      prop.load(in);
	      Enumeration key=prop.propertyNames();
	//      String key1=(String) key.nextElement();
	      while(key.nextElement()!=null)
	      {
	    	//  System.out.print(key1);
	    	  System.out.println(key.nextElement());
	      }
	      String a=prop.getProperty("1");
	 //     File[] drive = new File(a);
	   //   File[] drives = File.listRoots();
//	      for (File aDrive : drives) {
//	          System.out.println(aDrive);
//	      }
	   //  System.out.print(drive.getTotalSpace());
	   //   System.out.print(prop.getProperty("1"));
	      
	    //  prop.list(System.out);
	}

}
