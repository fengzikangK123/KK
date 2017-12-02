package com.kk.spring.aop.helloworld;

import com.kk.spring.aop.impl.ArithmeticCalculator;
import com.kk.spring.aop.impl.ArithmeticCalculatorImpl;

public class Main {

	public static void main(String[] args) {
		
//		ArithmeticCalculator arithmeticCalculator = null;
//		arithmeticCalculator = new ArithmeticCalculatorLogging();

		ArithmeticCalculator target= new ArithmeticCalculatorImpl();
	    ArithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
	
	
		
		int result = proxy.add(1, 2);
		System.out.println("-->" + result);

		result = proxy.div(4, 2);
		System.out.println("-->" + result);
	}
}
