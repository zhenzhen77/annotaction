package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Person;
import com.config.MainConfig;

public class MainTest {
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext applicationContext = 
//				new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = (Person) applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
	}

}
