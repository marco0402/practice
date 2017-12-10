package com.mcapp.practice.java8.optional;

import java.util.Optional;

public class OptionalPractice {
	public static void main(String[] args) {
		String userInput1 = null;
		String userInput2 = "";
		String userInput3 = "Marco";

		Optional<String> userInputOptional1 = Optional.ofNullable(userInput1);
		System.out.println("User Input 1 Present: " + userInputOptional1.isPresent());
		System.out.println("User Input 1 Value: " + userInputOptional1.orElseGet(() -> "Not Available"));
		System.out.println("User Input 1 Map: "
				+ userInputOptional1.map(s -> "Value " + s + " Available").orElse("Not Available"));

		Optional<String> userInputOptional2 = Optional.of(userInput2);
		System.out.println("User Input 2 Present: " + userInputOptional2.isPresent());
		System.out.println("User Input 2 Value: " + userInputOptional2.orElseGet(() -> "Not Available"));
		System.out.println("User Input 2 Map: "
				+ userInputOptional2.map(s -> "Value " + s + " Available").orElse("Not Available"));

		Optional<String> userInputOptional3 = Optional.of(userInput3);
		System.out.println("User Input 3 Present: " + userInputOptional3.isPresent());
		System.out.println("User Input 3 Value: " + userInputOptional3.orElseGet(() -> "Not Available"));
		System.out.println("User Input 3 Map: "
				+ userInputOptional3.map(s -> "Value " + s + " Available").orElse("Not Available"));
	}
}
