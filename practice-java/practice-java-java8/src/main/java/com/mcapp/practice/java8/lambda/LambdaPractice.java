package com.mcapp.practice.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaPractice {
	Runnable r;
	
	Comparator<Integer> c;
	
	LambdaFunctionalInterface<Integer> l;
	
	LambdaPractice() {
		r = () -> System.out.println(this); // this refer to LambdaPractice instance
		
		c = (Integer i1, Integer i2) -> i1.compareTo(i2); // return keyword can be skipped
		
		l = (i) -> i; // parameter type can be skipped
	}
	
	public String toString() {
		return "This is calling LambdaPractice toString method";
	}
	
	public static void main(String[] args) {
		LambdaPractice lp = new LambdaPractice();
		
		lp.r.run();
		
		List<Integer> l = Arrays.asList(300, 200, 100);
		Collections.sort(l, lp.c);
		l.forEach(i -> System.out.println(i));
		
		System.out.println(lp.l.execute(new Integer(123)));
	}
}
