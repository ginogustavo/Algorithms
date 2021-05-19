import java.util.Hashtable;

class CountParis {
    /**
     * Given an array of distinct integer values, count the number of pairs of
     * integers that have difference k: for example, given the array
     * {1,7,5,9,2,12,3} and the difference k = 2, thre are four pairs with
     * difference 2: (1,3), (3,5), (5,7), (7,9)
     */
    public static void main(String[] args) {
        pairs(new int[] { 1, 7, 5, 9, 2, 12, 3 });
    }

    public static int pairs(int[] array) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int current_value = array[i];
            hashtable.put(current_value, i);

            int pair1 = current_value + 2;
            int pair2 = current_value - 2;

            if (hashtable.get(pair1) != null) {
                count++;
                System.out.print("(" + current_value + "," + pair1 + ") ");
            }
            if (hashtable.get(pair2) != null) {
                count++;
                System.out.print("(" + current_value + "," + pair2 + ") ");
            }
        }
        System.out.println("\ncount: " + count);
        return count;
    }
}