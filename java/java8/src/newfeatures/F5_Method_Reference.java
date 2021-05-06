package newfeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Method reference is used to refer method of functional interface. It is
 * compact and easy form of lambda expression
 *
 * @author Gustavo
 *
 */
public class F5_Method_Reference {

	/**
	 * The operator :: is to separate object from method. There are 4 types of
	 * method reference
	 * 
	 * <pre>
	 * 1. to an instance method of an object – object::instanceMethod 
	 * 2. to a static method of a class – Class::staticMethod 
	 * 3. to an instance method of an arbitrary object of a particular type – Class::instanceMethod 
	 * 4. to a constructor – Class::new
	 * </pre>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		F5_Method_Reference f5 = new F5_Method_Reference();
		f5.quickView();
		f5.toInstanceMethodOfObject(); // 1
		f5.toInstanceMethodOfObject2();
		f5.toStaticMethodofAClass(); // 2
		f5.toInstanceMethodType();// 3
		f5.toConstructor(); // 4
	}

	private void quickView() {
		List<String> names = new ArrayList<>();
		names.add("Mark");
		names.add("John");
		names.add("Mathew");
		names.add("Luke");

		// Method reference is a shorthand notation of a lambda expression

		// If your lambda expression is this
		names.forEach(str -> System.out.println(str)); // long
		// It can be replaced by this
		names.forEach(System.out::println); // clean
	}

	private void toInstanceMethodOfObject() {

		// First, lambda can then be treated as instances of a functional interface
		// System.out.print does not have explicit interface type, but we can do this:
		Consumer<String> consumer = (s) -> System.out.println(s);

		consumer.accept("Hello");

		// Compiler determines Consumer.accept function matches the lambda's formal
		// parameter list and return type of "System.out.println()". The lambda is thus
		// bound to Consumer.

		// You can replace the lambda with a method reference
		Consumer<String> consumer2 = System.out::println;
		consumer2.accept("World");

	}

	@FunctionalInterface
	interface MyInterface {
		void display();
	}

	class MyClass {
		public void myMethod() {
			System.out.println("instanciated class method");
		}
	}

	private void toInstanceMethodOfObject2() {
		MyClass myObj = new MyClass();
		MyInterface myInterface = myObj::myMethod;
		myInterface.display();
	}

	private void toStaticMethodofAClass() {

		BiFunction<Integer, Integer, Integer> product = Multiplication::multiply;
		int pr = product.apply(11, 5);
		System.out.println("product is: " + pr);

	}

	private void toInstanceMethodType() {
		// Method reference to an instance method of an arbitrary object of a particular
		// type

		String[] stringArray = { "Steve", "Rick", "Rosita", "Negan", "Lucy", "Sansa", "Jon" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);

		Stream.of(stringArray).forEach(System.out::println);
	}

	@FunctionalInterface
	interface MyInterface2{
		MyClass2 display(String say);
	}
	class MyClass2{
		public MyClass2(String msg) {
			System.out.println(msg);
		}
	}
	private void toConstructor() {

		//Method reference to a constructor
        MyInterface2 ref = MyClass2::new;  
        ref.display("Hello World!");  
		
		/**
		 * <pre>
		Character::new;
				//equivalent to lambda 
		(Character ch) -> new Character(ch);
		
		Long::new;
				//equivalent to lambda 
		(long value) -> new Long(value); 
				//or 
		(String s) -> new Long(s);
		
		ArrayList<City>::new;
				//equivalent to lambda 
		() -> new ArrayList<City>();
		
		float[]::new;
				//equivalent to lambda 
		(int size) -> new float[size];
		 * </pre>
		 */
	}

}

class Multiplication {
	public static int multiply(int a, int b) {
		return a * b;
	}
}