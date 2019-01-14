package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
      
      
      HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
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
      
      ((AbstractApplicationContext) context).registerShutdownHook();
   }
}