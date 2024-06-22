package com.stream;

import java.util.*;
import java.util.stream.*;

public class IntermediateOpration {

	public static void main(String[] args) {

		List<String> list = List.of("monali", "pallavee", "vikas", "Akki");

		List<Integer> number = Arrays.asList(3, 4, 5, 6, 1, 2, 4, 9, 7, 66);

		// How do you convert a list of strings to uppercase using streams?
		List<String> v5 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(v5);

		// How do you count the number of elements in a stream
		long count = list.stream().count();
		System.out.println(count);

		// How do you find the maximum & minimum value in a list of integers using
		// streams?
		int max = number.stream().max(Integer::compareTo).get();
		int min = number.stream().min(Integer::compareTo).get();
		System.out.println(max);
		System.out.println(min);

		// How do you use the reduce method in Java streams?
		int total = number.stream().reduce(0, Integer::sum);
		System.out.println(total);
		
	    // Calculate the average of a list of integers using streams.
        double avg = number.stream().mapToInt(Integer::intValue).average().orElse(0);
        int sum = number.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum = "+sum + " average = "+avg);

		// How do you concatenate elements of a list into a single string using streams?
		String concatinated = list.stream().collect(Collectors.joining("+"));
		System.out.println(concatinated);

		// How do you partition a list of integers into even and odd numbers using
		// streams?
		Map<Boolean, List<Integer>> map = number.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println(map);

		// how do you group elements of a list by a certain criteria using streams?
		Map<Boolean, List<Integer>> group = number.stream().collect(Collectors.groupingBy(i -> i % 5 == 0));
		System.out.println(group);

		Map<Character, List<String>> map1 = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println(map1);

		// How do you handle exceptions in a stream pipeline?
		List<String> n = List.of("1", "7", "3", "4");
		List<Integer> num = n.stream().map(s -> {
			try {
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				throw e;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());

		System.out.println(num);

	}
}
