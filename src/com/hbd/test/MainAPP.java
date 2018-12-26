package com.hbd.test;

import com.hbd.entity.HelloIndia;
import com.hbd.entity.HelloWorld;
import com.hbd.entity.divo.JavaCollection;
import com.hbd.entity.divo.TextEditor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.beans.Beans;

public class MainAPP {
    public static void main(String[] args) {
        /*XmlBeanFactory factory = new XmlBeanFactory
                (new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        obj.getMessage();*/

        //AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      /*  HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.registerShutdownHook();*//*

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

        objA.getMessage1();
        objA.getMessage2();

        HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();*/


        //TextEditor te = (TextEditor) context.getBean("textEditor");
       // te.spellCheck();

//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        TextEditor te = (TextEditor) context.getBean("textEditor");
//        te.spellCheck();

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        JavaCollection jc=(JavaCollection)context.getBean("javaCollection");
        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();

    }
}
