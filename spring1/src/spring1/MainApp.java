package spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      //System.out.println("done");
     // HelloWorld obja = (HelloWorld) context.getBean("helloWorld");
     
     // obja.getMessage();
     // context.registerShutdownHook();
    //  HelloWorld objb =(HelloWorld) context.getBean("helloWorld");
      //objb.getMessage();
      TextEditor te= (TextEditor) context.getBean("textEditor");
      te.spellcheck();
   }
}