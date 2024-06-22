package com.stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WrapperClasses {
	public static void main(String[] args) {

		String s1 = "PallaveeJarad";
		String s2 = "ABC123";
		String name = "pallavee";
		int num = 123456;
		
		
		// calculate a frequency using stream
		Map<Character, Long> frequency = s1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		frequency.forEach((k, v) -> System.out.println(k + ":" + v));

		// Reverse givenString
		String revString = IntStream.range(0, s2.length()).mapToObj(m -> s2.charAt(s2.length() - 1 - m))
				.map(String::valueOf).collect(Collectors.joining());
		System.out.println(revString);

		// Find the first non-repeated character in a string using streams.
		char character = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
		System.out.println(character);

		// Count the frequency of each character in a string using streams.
		Map<Object, Long> map = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(map);
		
		// Reverse number using stream
		String number = Integer.toString(num);
		String reverseNum = IntStream.range(0, number.length()).mapToObj(m -> number.charAt(number.length() - 1 - m))
				.map(String::valueOf).collect(Collectors.joining());
		int revNum = Integer.parseInt(reverseNum);
		System.out.println(reverseNum);
		
		/* 
		 //convert uppercase
list.stream().map(String::toUpperCase).collect(Collectors.toList());

//count number of element in stream
list.stream/.count();

//max and min value 
num.stream().max(Integer::compareTo).get()
num.stream().min(Integer::compareTo).get()

//sum 
num.stream().reduce(0,Integer::sum);
num.stream().mapToInt(Integer::intValue).sum();

//average
num.stream().mapToInt(Integer::intvalue).average().orElse(0);

//list of string into string array[]
list.stream().collect(Collectors.joining(","));

//divide list of integer into even and odd
Map<Boolean, List<integer>> n= num.stream().collect(Collectors.partitioningBy(i->i%2==0))

//
infiniteStream = stream.iterate(0,i->i+2);
List<Integer> num =infiniteStream.limit(10).collect(Collectors.toList);

----------------------------------------

//get Duplicate Numbers
Set<Integer> seen = new HashSet<Integer>();
Set<Integer> duplicate= new HashSet<Integer>();
num.stream().filter(i->!seen.add(e)).filter(duplicate::add).collect(Colectrs.toList();)



//Revers String

String s1="CF45R";
String reversedString = Intstream.range(0,s1.length()).mapToObj(i->s1.charAt(s1.length()-1-i)).map(String::valueOf).collect(collectors.joining());


Stream.concat()
num1=list.of(1,2);
num2=list.of(3,2);

num1.stream().filter(num2::contains).collect(Collectors.joining)

people.stream().sorted(Comparator.comparing(Person::getAge())).collect(Collectors.tolist)


filter(e->e.equals(new StingBuilder(e).reverse.toString())).collect

String s1="Pallavee";

Map<Character,Long> fq = s1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));

fq.forEach(e->syso(e.getKey()"+"e.getValue()));

fq.entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).skip(1).findAny();

		 * */

	}
}
