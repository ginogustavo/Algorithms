package newfeatures;

import java.awt.Event;

/**
 * External iteration: Where a Collection provides, by implementing Iterable, 
 * a means to enumerate its elements i.e. Iterator
 * Problems:
 * 1) Java’s for-each loop/iterator is inherently sequential, and must process 
 * 		the elements in the order specified by the collection.
 * 2) It limits the opportunity to manage the control flow, which might be able to 
 * 		provide better performance by exploiting reordering of the data, parallelism, 
 * 		short-circuiting, or laziness.
 *
 * INTERNAL ITERATION: client let it handle by library and only provide the code which 
 *  must be executed for all/some of data elements
 *  
 *  External iteration mixes the “what” (uppercase) and the “how” (for loop/iterator), 
 *  Internal iteration lets the client to provide only the “what” but lets the library 
 *  control the “how”. ==> clean code
 *  
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class F4_StreamsAPI {

	public static void main(String[] args) {

		F4_StreamsAPI f4 = new F4_StreamsAPI();
		f4.creatingSreams();
		f4.collectStreamElements();
		f4.streamOperation();
		f4.shortCircuitOperation();
		f4.parallelismStream();
	}

	private void creatingSreams() {

		// 1. creating Stream from a fixed number of integers
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stream.forEach(p -> System.out.print(p + " "));

		// 2. from an array
		Integer[] myIntegerArray = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		Stream<Integer> stream2 = Stream.of(myIntegerArray);
		stream2.forEach(p -> System.out.print(p + " "));

		// 3. from a list
		List<Integer> myIntegerList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			myIntegerList.add(i);
		}
		Stream<Integer> stream3 = myIntegerList.stream();
		stream3.forEach(i -> System.out.print(i + " "));

		// 4. Stream.generate() or Stream.iterate()
		// restricted the elements count using limit() function.
		Stream<Integer> stream4_random = Stream.generate(() -> (new Random()).nextInt(100));
		stream4_random.limit(20).forEach(System.out::println);

		// 5. Stream of String chars or tokens
		IntStream stream5 = "12345_abcdefg".chars();
		stream5.forEach(p -> System.out.print(p + " "));

		Stream<String> stream6 = Stream.of("A$B$C$D".split("\\$"));
		stream6.forEach(p -> System.out.print(p + " "));

		// TODO: Stream.Builder

	}

	private void collectStreamElements() {

		// 1. Collect Stream elements to a List
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			intList.add(i);
		}
		Stream<Integer> stream = intList.stream();
		List<Integer> evenList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(evenList);
		// Collectors offers many other methods for set, Map, etc

		// 2. Collect Stream elements to an Array
		List<Integer> intList2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			intList2.add(i);
		}

		Stream<Integer> stream2 = intList2.stream();
		Integer[] oddArray = stream2.filter(i -> i % 2 != 0).toArray(Integer[]::new);
		System.out.println(oddArray[1]);

	}

	private List<String> getMemberList() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Alexander");
		memberNames.add("Samuel");
		memberNames.add("Anthony");
		memberNames.add("Robert");
		memberNames.add("Sergio");
		memberNames.add("Santiago");
		memberNames.add("Yin");
		memberNames.add("Liam");
		return memberNames;
	}

	private void streamOperation() {
		// Stream abstraction has a long list of useful functions.
		itermedaiteOperations();
		terminalOperations();
	}

	/**
	 * Intermediate operations return the stream itself so you can chain multiple
	 * methods calls in a row. Intermediate which enables us to call another stream
	 * operation
	 */
	private void itermedaiteOperations() {
		streamFilter(getMemberList());
		streamMap(getMemberList());
		streamSorted(getMemberList());
	}

	private void terminalOperations() {
		streamForEach(getMemberList());
		streamCollect(getMemberList());
		streamMatch(getMemberList());
		streamCount(getMemberList());
		streamReduce(getMemberList());
	}

	private void streamFilter(List<String> memberNames) {
		memberNames.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);
	}

	/**
	 * .map() - converts each element in the stream into another object via the
	 * given function.
	 * 
	 * @param memberNames
	 */
	private void streamMap(List<String> memberNames) {
		memberNames.stream().filter(s -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

		// we can use map() to transform an object into another type as well
	}

	/**
	 * sorted in natural order unless we pass a custom Comparator
	 * 
	 * @param memberNames
	 */
	private void streamSorted(List<String> memberNames) {
		// It creates a sorted view of the stream without manipulating the ordering of
		// the source Collection
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
	}

	private void streamForEach(List<String> memberNames) {
		memberNames.forEach(System.out::println);
	}

	private void streamCollect(List<String> memberNames) {
		// It's used to receive elements from a steam and store them in a collection

		List<String> namesUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());

		namesUppercase.forEach(System.out::println);

	}

	/**
	 * Various matching operations can be used to check whether a given predicate
	 * matches the stream elements. All of these matching operations are terminal
	 * and return a boolean result.
	 * 
	 * @param memberNames
	 */
	private void streamMatch(List<String> memberNames) {

		boolean matchedResult = memberNames.stream().anyMatch(s -> s.startsWith("A"));
		System.out.println("anyMatch start with A " + matchedResult);

		matchedResult = memberNames.stream().allMatch(s -> s.startsWith("A"));
		System.out.println("AllMatch start with A " + matchedResult);

		matchedResult = memberNames.stream().noneMatch(s -> s.startsWith("A"));
		System.out.println("NoneMatch start with A " + matchedResult);

	}

	private void streamCount(List<String> memberNames) {
		// the number of elements in the stream as a long value
		long total = memberNames.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("Total start with A " + total);
	}

	/**
	 * Reduction on the elements of the stream with the given function. The result
	 * is an Optional holding the reduced value
	 * 
	 * @param memberNames
	 */
	private void streamReduce(List<String> memberNames) {
		// Reducing all the strings by concatenating them using a separator #
		Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
	}

	/**
	 * Desired to break the operation whenever a matching element is encountered
	 * during iteration(internal iterations such as in streams).
	 */
	private void shortCircuitOperation() {
		streamAnyMatch(getMemberList());
		streamFindFirst(getMemberList());
	}

	private void streamAnyMatch(List<String> memberNames) {
		// Once a matching value is found, no more elements will be processed in the
		// stream
		boolean matched = memberNames.stream().anyMatch(s -> s.startsWith("A"));
		System.out.println(matched);
	}

	private void streamFindFirst(List<String> memberNames) {
		// will return the first element from the stream and then it will not process
		// any more elements.
		String firstMatch = memberNames.stream().filter(s -> s.startsWith("L")).findFirst().get();
		System.out.println(firstMatch);
	}

	/**
	 * fork/join framework (java7) is itself a complex task. To enable parallelism,
	 * all we have to do is to create a parallel stream, instead of a sequential
	 * stream.
	 */
	private void parallelismStream() {
		// Anytime we want to do a particular job using multiple threads in parallel
		// cores, all we have to call parallelStream() method instead of stream()
		// method.

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}

		// Here we create a parallel stream
		Stream<Integer> stream = list.parallelStream();

		Integer[] evenNumbers = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);

		Stream<Integer> streamofEvenNumbers = Stream.of(evenNumbers);
		streamofEvenNumbers.forEach(System.out::println);

	}

	// Guided by :https://howtodoinjava.com/java8/java-streams-by-examples/
}