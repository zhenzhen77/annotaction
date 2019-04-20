package com.beans;

import org.springframework.beans.factory.FactoryBean;
//创建一个spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color>{

	@Override
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean....getObject....");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	//是否是单例
	//ture，这个bean是单实例，在容器中保存一份
	//false，多实例，每次获取都会创建一个新的bean
	@Override
	public boolean isSingleton() {
		return false;
	}


	

}
