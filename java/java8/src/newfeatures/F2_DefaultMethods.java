package newfeatures;

/**
 * Default methods enable you to add new functionality to the interfaces of your
 * libraries and ensure binary compatibility with code written for older
 * versions of those interfaces.
 * 
 * It helps library designers to evolve their APIs in a backward-compatible way,
 * 
 * @author Gustavo
 *
 */
interface Movable {
	default void move() {
		System.out.println("Interface deafult method");
	}
}

class Vehicle implements Movable {
}

class Animal implements Movable {
	@Override
	public void move() {
		System.out.println("Animal is moving");
	}
}

public class F2_DefaultMethods {

	public static void main(String[] args) {

		Animal a = new Animal();
		a.move();

		Vehicle v = new Vehicle();
		v.move();

	}
}
