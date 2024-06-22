package com.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Transaction {

	int value;

	public Transaction(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

class Person {

	int age;
	String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

}

public class PracticalCoding {

	public static void main(String[] args) {

		List<Transaction> transactions = Arrays.asList(new Transaction(100), new Transaction(200),
				new Transaction(300));

		List<Person> people = Arrays.asList(new Person(25, "Alice"), new Person(6, "Bob"), new Person(12, "Akki"),
				new Person(14, "Vikas"));

		List<String> findPalendrome = Arrays.asList("akka", "mom", "pappa", "mummy");

		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> numbers2 = Arrays.asList(4, 5, 6, 7, 8);

		List<Integer> duplicateNumber = Arrays.asList(6, 6, 7, 7, 4, 5, 6, 7, 8);

		List<String> list = List.of("monali", "pallavee", "vikas", "Akki", "momoli", "rutuja", "gorgie");

		// get duplicate numbers
		Set<Integer> uni = new HashSet<Integer>();
		Set<Integer> duplicate = new HashSet<Integer>();

		Set<Integer> duplicateNo = duplicateNumber.stream().filter(e -> !uni.add(e)).filter(duplicate::add)
				.collect(Collectors.toSet());
		System.out.println("duplicateNo are = " + duplicateNo);

		// Reverse Given String using stream
		String v = "Pallavee23";
		String reveredString = IntStream.range(0, v.length()).mapToObj(i -> v.charAt(v.length() - 1 - i))
				.map(String::valueOf).collect(Collectors.joining());
		System.out.println(reveredString);

		// Given a list of transactions, filter out those with a value less than a 250
		// and sum the rest.
		int sum = transactions.stream().filter(s -> s.value < 190).mapToInt(Transaction::getValue).sum();
		System.out.println(sum);

		// Convert a list of objects to a map using streams.
		Person p1 = new Person();
		Map<Integer, String> peopleMap = people.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
		System.out.println(peopleMap);

		// Calculate the average of a list of integers using streams.
		double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
		int total = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println("sum = " + total + " average = " + avg);

		// Merge two lists of integers and remove duplicates using streams.
		List<Integer> concatinated = Stream.concat(numbers.stream(), numbers2.stream()).distinct()
				.collect(Collectors.toList());
		System.out.println(concatinated);

		// Find the common elements between two lists using streams.
		List<Integer> common = numbers.stream().filter(numbers2::contains).collect(Collectors.toList());
		System.out.println(common);

		// Sort a list of custom objects using streams.
		List<Person> sortbyAge = people.stream().sorted(Comparator.comparing(Person::getAge))
				.collect(Collectors.toList());
		System.out.println("sortbyAge = " + sortbyAge);

		List<Person> sortByName = people.stream().sorted(Comparator.comparing(Person::getName))
				.collect(Collectors.toList());
		System.out.println("sortbyName = " + sortByName);

		// Filter a list of strings based on length and sort them using streams.
		List<String> filteredString = list.stream().filter(s -> s.length() > 4).sorted().collect(Collectors.toList());
		System.out.println(filteredString);

		// find palindrome String

		List<String> palindromes = findPalendrome.stream().filter(e -> e.equals(new StringBuilder(e).reverse().toString())).collect(Collectors.toList());
		System.out.println("palindromes are == " + palindromes);
	}

	public static boolean isPalindrome(String s) {

		String rev = new StringBuilder(s).reverse().toString();
		return rev.equals(s);

	}
}
