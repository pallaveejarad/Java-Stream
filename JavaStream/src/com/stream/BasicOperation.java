package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicOperation {

	public static void main(String[] args) {
		System.out.println("Stream Examples");

		List<String> list = new ArrayList<String>(Arrays.asList("hi", "Hello", "Pallavee", "Vikas", "Pankaj"));

		List<Integer> num = Arrays.asList(1, 2, 3, 4, 56, 7, 8, 9);

		Stream<String> stream = Stream.of("pallavee", "vikas", "Hello", "Pallavee", "Vikas", "Pankaj");

		String[] arr = { "a", "b", "c" };
		
		// How do you create a stream from a list?
		Stream<String> l2 = list.stream();
		System.out.println(l2);
		
		Stream<String> x= Stream.of("a","v","g");
		Stream<String> x2= list.stream();
		Stream<String> x3= Arrays.stream(arr);

		List<Integer> nums = num.stream().filter(e->e>20).collect(Collectors.toList());
		
		
		// How do you create a stream from an array?
		
		Stream<String> newArray = Arrays.stream(arr);
		System.out.println(newArray);

		// filter a stream in Java?
		List<Integer> dividedByTwo = num.stream().filter(i -> (i & 1) == 0).collect(Collectors.toList());
		System.out.println(dividedByTwo);

		// How do you convert a stream to a list?
		List<String> newList = stream.collect(Collectors.toList());
		System.out.println(newList);

		// How do you sort a stream of strings?
		List<String> l3 = stream.sorted().collect(Collectors.toList());
		System.out.println(l3);

		// How do you remove duplicates from a stream?
		List<String> v2 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(v2);

		// What is the purpose of the peek method in streams?
		/*
		 * The peek method is used to perform a side-effecting action on each element of
		 * the stream as it is consumed, typically for debugging purposes.
		 */
		List<String> v5 = list.stream().peek(System.out::println).collect(Collectors.toList());

	}
}
