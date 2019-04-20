package com.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.MainCinfigOfAutowired;
import com.dao.BookDao;
import com.service.BookService;

public class IOCTest_Autowired {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(MainCinfigOfAutowired.class);
		BookService bean = applicationContext.getBean(BookService.class);
		System.out.println(bean);
		BookDao bean2 = applicationContext.getBean(BookDao.class);
		System.out.println(bean2);



	}

}
