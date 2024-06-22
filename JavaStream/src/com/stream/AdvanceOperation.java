package com.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import java.util.function.Function;

public class AdvanceOperation {

	public static void main(String[] args) {

		List<Integer> number = List.of(2, 3, 4, 5, 6, 7, 8, 8, 9, 7, 90, 5);

		List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8),
				Arrays.asList(9, 9));

		// What are infinite streams and how do you create them?
		Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
		List<Integer> firstTen = infiniteStream.limit(10).collect(Collectors.toList());
		System.out.println(firstTen);

		// How do you use parallel streams in Java?
		int sum = number.parallelStream().reduce(0, Integer::sum);
		System.out.println(sum);

		// How do you flatMap a list of lists in Java streams
		List<Integer> flatList = listOfList.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
		System.out.println(flatList);
		
		
		//How do you find the second highest number in a list using streams?		
		int secondHighest =  number.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findAny().get();
		System.out.println(secondHighest);
		
		

	}
}
