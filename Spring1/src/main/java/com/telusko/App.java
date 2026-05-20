package com.telusko;

import com.telusko.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Computer dt = context.getBean("desktop",Desktop.class);
		dt.compile();

		Alien a1 = context.getBean(Alien.class);
		a1.code();

//    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");  // create a container
//    	Alien obj1 = (Alien) context.getBean("alien1");
//    	obj1.setAge(21);
//    	System.out.println(obj1.getAge());
//
//    	obj1.code();
//
//    	Alien obj2 = (Alien) context.getBean("alien1");
//    	System.out.println(obj2.getAge());
//    	obj2.code();

    }
}
