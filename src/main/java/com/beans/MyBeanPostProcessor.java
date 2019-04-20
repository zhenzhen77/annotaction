package com.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 
* <p>Title: MyBeanPostProcessor</p>  
* <p>Description: </p>  
* @author 郑世伟  
* @date 2019年4月4日
* 后置处理器，初始前后进行工作
* 将后置处理器加入到容器中
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization..." + beanName + "==>" + bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization..." + beanName + "==>" + bean);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
	
}
