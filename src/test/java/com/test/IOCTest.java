package com.test;

import java.util.Iterator;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.beans.Bule;
import com.beans.Person;
import com.config.MainConfig;
import com.config.MainConfig2;

public class IOCTest {
	AnnotationConfigApplicationContext applicationContext = 
			new AnnotationConfigApplicationContext(MainConfig2.class);
	
	@Test
	public void testImport(){
		printBean(applicationContext);
		Bule bean = applicationContext.getBean(Bule.class);
		System.out.println(bean);
		
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		Object bean3 = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean的类型：" + bean2.getClass());
		System.out.println(bean2 == bean3);
		
		Object bean4 = applicationContext.getBean("&colorFactoryBean");
		System.out.println("bean的类型：" + bean4.getClass());
	}
	
	private void printBean(AnnotationConfigApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
			
		}
		
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
	
	@Test
	public void scope(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig2.class);
//		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//		for (String string : beanDefinitionNames) {
//			System.out.println(string);
//		}
		System.out.println("ioc容器创建完成");
		Person bean = (Person) applicationContext.getBean("xiaoxiao");
		Person bean2 = (Person) applicationContext.getBean("xiaoxiao");
////		
//		System.out.println(bean==bean2);
	}
	@Test
	public void conditional(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainConfig2.class);
		//获取一个环境变量
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		//动态获取环境变量的值：Windows 7
		String property = environment.getProperty("os.name");
		System.out.println(property);
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}
	
	
}








