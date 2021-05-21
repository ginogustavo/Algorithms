package problems.arrays;

import java.util.Arrays;

/**
 * Delete element from an array O(n)
 */
public class DeleteElement {

    public static void main(String[] args) {
        DeleteElement app = new DeleteElement();

        int[] test = new int[]{8, 5, 3, 1, 8, 73, 4};
        int position = app.findPosition(test, 3);
        System.out.println(position);
        app.delete(test, position);
        Arrays.stream(test).forEach(System.out::println);


    }

    private int findPosition(int[] arr, int value) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == value)
                return i;
        }
        return 0;
    }

    private void delete(int[] arr, int position) {
        for (int i = position; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }
}
