package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *自动装配;
 *		spring利用依赖注入（DI），完全对IOC容器中各个组件的依赖关系赋值
 *1）、@Autowired，自动注入
 *		1）、默认优先按照类型去容器中找对应的组件: applicationContext.getBean(BookDao.class)
 * 		2)、
 * 		BookService{
 * 			@Autowired
 * 			BookDao bookdao
 * }
 */
@ComponentScan({"com.service","com.dao","com.controller"})
@Configuration
public class MainCinfigOfAutowired {

}
