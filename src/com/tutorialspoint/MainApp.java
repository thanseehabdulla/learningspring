package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.*;

public class MainApp {
   private static ApplicationContext context;
   private static ApplicationContext ctx, ctx2;


public static void main(String[] args) {
      context = new ClassPathXmlApplicationContext("Beans.xml");
    
      // Let us raise a start event.
      ((AbstractApplicationContext) context).start();
      
      
      ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
//      ctx2 = new AnnotationConfigApplicationContext(TextEditorConfig.class);
      
      HelloWorld obj = (HelloWorld) ctx.getBean("helloWorld");
      obj.getMessage();
      
//      TextEditor tes = ctx2.getBean(TextEditor.class);
//      tes.spellCheck();
      
      
      HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
      objB.getMessage();
      objB.setMessage("Thanseeh");
      objB.getMessage();
      
      HelloIndia objC = (HelloIndia) context.getBean("helloIndia");
      objC.getMessage1();
      objC.getMessage2();
      objC.getMessage3();
      
      TextEditor te = (TextEditor) context.getBean("textEditor");
      te.spellCheck();
      
      JavaCollection jc=(JavaCollection)context.getBean("javaCollection");

      jc.getAddressList();
      jc.getAddressSet();
      jc.getAddressMap();
      jc.getAddressProp();
      
   // Let us raise a stop event.
      ((AbstractApplicationContext) context).stop();
      
      CustomEventPublisher cvp = 
    	         (CustomEventPublisher) context.getBean("customEventPublisher");
    	      
    	      cvp.publish();  
    	      cvp.publish();
      
      ((AbstractApplicationContext) context).registerShutdownHook();
   }
}