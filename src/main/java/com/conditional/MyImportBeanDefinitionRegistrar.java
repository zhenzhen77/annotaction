package com.conditional;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.beans.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/**
	 * AnnotationMetadata:当前类的注解消息
	 * BeanDefinitionRegistry:BeanDefinition的注册类，
	 * 		把所有需要添加到容器的bean，调用
	 * 		BeanDefinitionRegistry.registerBeanDefinition手动注册进来
	 */
	
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("com.beans.Bule");
		boolean definition2 = registry.containsBeanDefinition("com.beans.Yellow");
		if(definition && definition2){
			//指定Bean定义信息:（bean的类型）
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			//注册一个Bean，指定bean名
			registry.registerBeanDefinition("rainbow", beanDefinition);
		}
		
	}

}
