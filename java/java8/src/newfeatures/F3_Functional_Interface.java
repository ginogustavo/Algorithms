package newfeatures;

/**
 * Functional interfaces are also called Single Abstract Method interfaces (SAM
 * Interfaces). It is only for informing the compiler to enforce single abstract
 * method inside interface. Functional interfaces can be represented using
 * lambda expressions, method reference and constructor references as well
 * 
 * @author Gustavo
 *
 */

@FunctionalInterface
interface Buyable {
	int calculateTax(); // if marked as Func. Interface, only one abstract method

	default void printTotal() {
		// default methods don't count as abstract method.
	};
}

public class F3_Functional_Interface {

	public static void main(String[] args) {

	}
}
