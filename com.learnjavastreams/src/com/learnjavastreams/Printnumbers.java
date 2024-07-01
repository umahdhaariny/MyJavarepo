package com.learnjavastreams;
import java.util.List;

public class Printnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printAllNumbersInListinfucntional(List.of(12,9,1,22,4,5,6));
	}

	public static void printAllNumbersInListinfucntional(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);
	}
}
