/**
 * Rotation array
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.

 */
package array_hashtable_string.array;

public class Rotation {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		Rotation app = new Rotation();
		int[] newArray = app.rotate(array, 2, 7);
		for (int i : newArray) {
			System.out.print(" " + i);
		}
	}

	public int[] rotate(int ar[], int d, int n) { // n=size, d=#elements to rotate
		//Method 1 - 2 arrays.
//		int[] a1 = new int[n - d];
//		int[] a2 = new int[d];
//		
//		for (int i = 0; i < d; i++) {
//			a2[i] = ar[i];
//		}
//		int index_a2 = 0;
//		for (int i = (d + 1); i < (n - 1); i++) {
//			a1[index_a2] = ar[i];
//			index_a2++;
//		}

		
		//Method 2 - 1 array
		int[] newArray = ar.clone();
		int counter2 = n - d;
		int counter1 = 0;

		for (int i = 0; i < ar.length; i++) {

			if (counter2 < n) {
				newArray[counter2] = ar[i];
				counter2++;
			} else {
				newArray[counter1] = ar[i];
				counter1++;
			}

		}

		return newArray;

	}

}
