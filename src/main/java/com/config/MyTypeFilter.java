package com.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/*
	 * metadataReader:读取当前正在扫描的类的信息
	 * metadataReaderFactory:可以获取其他任何类的信息
	 */
	public boolean match(MetadataReader arg0, MetadataReaderFactory arg1) throws IOException {
		// TODO Auto-generated method stub
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = arg0.getAnnotationMetadata();
		//获取当前正在扫描的类的信息
		ClassMetadata classMetadata = arg0.getClassMetadata();
		//获取当前类资源（如类的路径）
		Resource resource = arg0.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("-------->" + className);
		if(className.contains("er")){
			return true;
		}
		return false;
	}

}





