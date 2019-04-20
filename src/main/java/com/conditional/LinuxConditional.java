package com.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否是linux系统
public class LinuxConditional implements Condition{
	/*
	 * ConditionContext:判断条件能使用的上下文（环境）
	 * AnnotatedTypeMetadata：注释信息
	 * */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//能获取到ioc使用的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取当前环境信息
		Environment environment = context.getEnvironment();
		//获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		
		String property = environment.getProperty("os.name");
		if(property.contains("linux")){
			return true;
		}
		return false;
	}

}
