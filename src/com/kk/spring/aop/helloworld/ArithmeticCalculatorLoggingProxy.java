package com.kk.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

import com.kk.spring.aop.impl.ArithmeticCalculator;

public class ArithmeticCalculatorLoggingProxy {

	// Ҫ����Ķ���
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
           this.target=target;
	}
	
	// ����һ����־����
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;

		// �����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		// �����������ͣ�����������Щ����
		Class[] interfaces = new Class[] { ArithmeticCalculator.class };
		// �����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler h = new InvocationHandler() {
             /**
              * proxy:���ڷ��ص��Ǹ��������һ������£���invoke�����ж���ʹ�øö���
              * method:���ڱ����õķ���
              * args:���÷���ʱ������Ĳ���
              */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) 
					throws Throwable {
				String methodName =method.getName();
				//��־
				System.out.println("KK->The method "+methodName+" begins with "+Arrays.asList(args));
				
				//ִ�з���
				Object result =method.invoke(target, args);
				//��־
				System.out.println("KK->The method " + methodName+" ends with "+result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}

}
