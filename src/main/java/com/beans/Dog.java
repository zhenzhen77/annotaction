package com.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
@Component
public class Dog {

	public Dog(){
		System.out.println("dog constructor.....");
	}
	@PostConstruct
	public void init(){
		System.out.println("dog @PostConstruct.....");
	}
	@PreDestroy
	public void distory(){
		System.out.println("dog @PreDestroy.....");
	}
}
