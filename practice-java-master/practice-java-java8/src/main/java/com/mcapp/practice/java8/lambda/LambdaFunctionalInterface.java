package com.mcapp.practice.java8.lambda;

@FunctionalInterface
public interface LambdaFunctionalInterface<T> {
	T execute(T obj);
}
