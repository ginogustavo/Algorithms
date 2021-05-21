package problems.arrays;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[]
 * of size n by d elements.
 *
 * ex.
 * array = 1 2 3 4 5 6 7
 * Rotation of the above array by 2 will make array
 * 3 4 5 6 7 1 2
 *
 */
public class RotationArray {
    public static void main(String[] args) {

//        int[] test = RotationArray.rorate1(new int[]{1,2,3,4,5,6,7}, 2, 8);
        //int[] test = RotationArray.rorate2(new int[]{1,2,3,4,5,6,7}, 2, 8);

        int[] myArray = new int[]{1,2,3,4,5,6,7};
        Arrays.stream(myArray).forEach(System.out::print);
        RotationArray.rorate2( myArray, 2, 8);
        System.out.println("");
        Arrays.stream(myArray).forEach(System.out::print);
    }

    // Method 1: first try.
    // time O(n)
    // space O(d)
    private static int[] rorate1(int[] arr, int d, int n){
        int[] tempArray = new int[d];
        for (int i = 0; i < d; i++) {
            tempArray[i] = arr[i];
        }
        for (int i = d; i <n-1; i++) {
            arr[i-d] = arr[i];
        }
        int newStart = n-d-1;
        int tempIndex = 0;
        for (int i = newStart; i <n-1 ; i++) {
            arr[i] = tempArray[tempIndex++];
        }
        return arr;
    }

    /**
     * Method 2: rotate by one and by 2 times.
     * Time complexity : O(n * d)
     * Auxiliary Space : O(1)
     */
    private static void rorate2(int[] arr, int d, int n){

        for (int i = 0; i < d ; i++) {
            arr = leftRotateByOne(arr);
        }

        //return arr;
    }

    private static int[] leftRotateByOne(int[] arr){
        int temp = arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
        return arr;
    }

}
