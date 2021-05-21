package problems.arrays;

import java.util.Arrays;

/**
 * Given an array and a number k where k is smaller than the size of the array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 3
 * Output: 7
 * <p>
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 4
 * Output: 10
 */
public class SmallestK {
    public static void main(String[] args) {

        int[] array = new int[]{7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(SmallestK.findSmalledK( array, k));
        //array = new int[]{7, 10, 4, 3, 20, 15};
        k = 4;
        System.out.println(SmallestK.findSmalledK( array, k));



    }

    /**
     * Method1: first try
     * sort and get k indexed
     * O(n log n)
     *
     */
    private static int findSmalledK(int[] arr, int k){
        Arrays.sort(arr);
        return arr[k-1];
    }

    /**
     * todo: alternative without sorting
     *
     */


}
