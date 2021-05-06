package newfeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class F1_Lambda {

	public static void main(String[] args) {
		new F1_Lambda().useOfComparator();
		new F1_Lambda().useComparatorLambdas();
	}
	

	/**
	 * Before Java 8
	 */
	private void useOfComparator() {
		List<String> fruits = new ArrayList<>();
		fruits.add("Watermelon");
		fruits.add("Strawberries");
		fruits.add("Pear");
		fruits.add("Apples");
		fruits.add("Pineaple");
		fruits.add("Bananas");
		fruits.add("Grapes");
		
		Collections.sort( fruits , new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		System.out.println(fruits);

	}
	
	
	
	
	/**
	 * With Java 8
	 */
	private void useComparatorLambdas() {
		List<String> fruits = new ArrayList<>();
		fruits.add("Watermelon");
		fruits.add("Strawberries");
		fruits.add("Pear");
		fruits.add("Apples");
		fruits.add("Pineaple");
		fruits.add("Bananas");
		fruits.add("Grapes");
		
		Collections.sort( fruits, (o1,o2)-> o1.compareTo(o2));

		System.out.println(fruits);

		
		// Example with custom objects
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple(250));
		apples.add(new Apple(100));
		apples.add(new Apple(99));
		apples.add(new Apple(300));
		apples.add(new Apple(110));
		
//		Comparator<Apple> byWeight = (Apple a1, Apple a2) -> 
//			Float.compare(a1.getWeight(), a2.getWeight());
//		Collections.sort( apples, byWeight );
		
		
		Collections.sort( apples, 
				(Apple first, Apple second)-> 
					Float.compare(first.getWeight(), second.getWeight()));
		
		
		System.out.println(apples);
		
	}
	
	public class Apple {
		float weight;
		public Apple() {}
		public Apple(float weight) {
			this.weight = weight;
			
		}
		
		public float getWeight() {
			return weight;
		}
		public void setWeight(float weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return String.valueOf(this.weight);
		}
	}

}
