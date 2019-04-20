package com.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.beans.Person;
import com.config.MainConfigOfPropertyValue;

public class IOCTest_PropertyValue {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			MainConfigOfPropertyValue.class);

	@Test
	public void test() {
		printBean(applicationContext);
		System.out.println("===============");

		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
	}

	private void printBean(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
}
