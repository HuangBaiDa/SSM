/*
package com.hbd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hbd.controller.StudentAction;
import com.hbd.entity.Student;

public class DemoApp1 {

	public static void main(String[] args) {
		//获取IOC容器》》》该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student stu1 = (Student) applicationContext.getBean("student1");
		System.out.println(stu1.toString());
		
		StudentAction stuAction = (StudentAction) applicationContext.getBean("studentAction");
		stuAction.addStudent();
	}

}
*/
