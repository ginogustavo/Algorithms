package problems.arrays;

import java.util.Arrays;

/**
 * Given an array of integers, print the array in such a way that the first element is first maximum and second element is first minimum and so on.
 * Examples :
 *
 *
 * Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
 * Output : 7 1 6 2 5 3 4
 *
 * Input : arr[] = {1, 6, 9, 4, 3, 7, 8, 2}
 * Output : 9 1 8 2 7 3 6 4
 */
public class AlternativeSorting {
    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 2, 3, 4, 5, 6};
//        int[] newArray = AlternativeSorting.altsort( array );
        int[] newArray = AlternativeSorting.altsort2( array );

        Arrays.stream(newArray).forEach(System.out::print);
        
    }

    private static int[] altsort(int[] arr){
        Arrays.sort(arr);

        //take last, and first and pair at the bieging.
        int[] newArray = new int[arr.length];
        int minor, major, indexMinor, indexMajor, count = 0;
        int top = (int)Math.ceil((double)arr.length/2);
        for (int i = 0; i < top ; i++) {
            indexMinor = i;
            indexMajor = arr.length-1-i;
            minor = arr[indexMinor];
            major = arr[indexMajor];

            if (indexMajor == indexMinor){
                newArray[count] = major;
            }else{
                newArray[count++] = major;
                newArray[count++] = minor;
            }
        }
        return newArray;
    }

    //using while
    public static int[] altsort2(int[] array){
        Arrays.sort(array);

        int i = 0;
        int j = array.length-1;

        while(i<j){
            System.out.println(array[i]);
            System.out.println(array[j]);
            i++;
            j--;
        }

        if(array.length%2 !=0)
            System.out.println(array[i]);
        return array;

    }
}
