package test;
import java.util.ArrayList;
import java.util.*;
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
              List<String> myList = new ArrayList<>();
             String a=prop.getProperty("1");
             String b=prop.getProperty("2");
          
             myList.add(a);
             myList.add(b);
           //  System.out.println(myList);
             Iterator iterator = myList.iterator();
             while(iterator.hasNext()) {
                String a1=(String) iterator.next();
             
             File drive = new File(a1);
             
             long freeSpace = drive.getFreeSpace();
             long totalSpace = drive.getTotalSpace();
             long avail_space=totalSpace-freeSpace;
             long space=(long) (.8*totalSpace);
             System.out.println(space); 
           System.out.println(drive.getFreeSpace());
           System.out.println(drive.getTotalSpace());
           if(avail_space<space)
          System.out.println(a1+" disk space:"+avail_space);

       }
       }
}
