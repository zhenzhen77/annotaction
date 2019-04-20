package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
//配置类==配置文件
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.beans.Person;
@Configuration     //告诉spring这是个配置类
@ComponentScan(value="com",includeFilters={
//		@Filter(type=FilterType.ANNOTATION,classes={Service.class}),
		@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})},useDefaultFilters=false)
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[]， 指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[]，指定扫描的时候只需要包含那些组件
//FilterType.ANNOTATION:按照注解
//FilterType.ASPECTJ:使用ASPECTJ表达式
//FilterType.ASSIGNABLE_TYPE:按照给定类型
//FilterType.REGEX:按照正则指示
//FilterType.CUSTOM:按照自定义规则
public class MainConfig {

	//给容器中注入一个bean，类型为返回值的类型，id默认是方法名作为id
	@Bean(value="person")
	public Person person011(){
		return new Person("郑世玲","29","玲玲");
	}
}
