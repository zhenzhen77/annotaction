package com.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.beans.Color;
import com.beans.ColorFactoryBean;
import com.beans.Person;
import com.conditional.LinuxConditional;
import com.conditional.MyImportBeanDefinitionRegistrar;
import com.conditional.MyImportSelector;
import com.conditional.WindowsConditional;

@Conditional({ WindowsConditional.class })
@Configuration
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

	// 默认是单例的
	/*
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
	 * 
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON singleton
	 * 
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * request
	 * 
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * session
	 * 
	 * 
	 * prototype 多实例：ioc容器启动并不会调用方法创建对象放到容器中， 每次获取的时候才会调用方法创建对象 singleton
	 * 单例，ioc容器启动会调用方法创建对象放到ioc容器中， 以后每次获取都是直接从容器（map。get）拿 request 同一次请求创建一个实例
	 * session 同一个session创建一个实例
	 * 
	 * 
	 * 懒加载 单实例bean：默认在容器启动的时候创建对象 懒加载：容器启动不创建对象，第一次使用bean创建对象，并初始化
	 */
	// @Scope("prototype")
	@Lazy
	@Bean(value = "xiaoxiao")
	public Person person() {
		System.out.println("给容器添加xiaoxiao");
		return new Person("郑子衿", "3");
	}

	/*
	 * @conditional({Condition}),按照一定条件进行判断，满足条件给容器注册bean
	 * 
	 * 如果系统是windows，给容器中注册（"biller"） 如果是linux系统，给容器中注册（"yuehan"）
	 */
	@Conditional({ WindowsConditional.class })
	@Bean(value = "biller")
	public Person personn01() {
		return new Person("比尔盖茨", "62");
	}

	@Conditional({ LinuxConditional.class })
	@Bean(value = "yuehan")
	public Person personn02() {
		return new Person("约翰", "35");
	}

	/**
	 * 给容器中注册组件 
	 * 1）、包扫描+组件标注注解（@controller/@service/@repository/@component）【自己的方法】
	 * 2）、@bean【导入第三方包里的组件】 
	 * 3）、@import【快速给容器中导入一个组件】
	 * 		1)、@import(要导入到容器中的组件)，容器中就会自动注册这个组件，id默认是全类名
	 * 		2)、ImportSelector：返回需要导入的组件的全类名数组
	 * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
	 * 4）、使用Spring提供的FactoryBean（工厂Bean）;
	 * 		1）、默认获取到的工厂Bean调用getobject创建的对象
	 * 		2）、要获取工厂Bean本身，我们需要在id前面加一个&
	 * 			&colorFactoryBean
	 */
	
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
}
