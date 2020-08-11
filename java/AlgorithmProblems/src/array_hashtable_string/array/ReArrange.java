package array_hashtable_string.array;

import java.util.Arrays;

public class ReArrange {
	/**
	 * 	Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
	 *  Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
	 * @param args
	 */
	public static void main(String[] args) {
		ReArrange app = new ReArrange();
		int[] array = new int[] {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

		int[] result = app.rearrange(array);
		for (int i : result) {
			System.out.print(" " + i);
		}
		
	}
	
	public int[] rearrange(int[] ar) {
		
		int[] newArray = ar.clone();
		Arrays.sort(newArray);
	
		
		for (int i = 0; i < ar.length; i++) {
			if( ar[i] == i) {
				
			}
			//if there is a 0 m put in this location else -1
			
			
		}
		
		//search the next, y paso al sgte
		
		//si llegue a u numero > 0,  take it.
		// -1 3 5 6 7
		
		
		
		
		return ar;
	}
	

}
