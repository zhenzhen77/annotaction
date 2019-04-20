package com.beans;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	//使用@value赋值
	//1、基本数值
	//2、可以写SpEL，#{}
	//3、可以写${}，取配置文件【properties】的值（在运行环境）
	
	@Value("张三")
	private String name;
	@Value("#{30-5}")
	private String age;
	@Value("${person.nickName}")
	private String nickName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}
	
	public Person(String name, String age, String nickName) {
		super();
		this.name = name;
		this.age = age;
		this.nickName = nickName;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
