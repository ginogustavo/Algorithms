package practice;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Equation {
    /**
     * Print all possible solution of the equation a^3 + b^3 = c^3 + d^3, where
     * a,b,c,d are integers from 1 - 1000
     */
    public static void main(String[] args) {

        /**
         * Brute force:
         * 
         * <pre>
         * for a 1-1000
         *      for b 1-1000
         *          for c 1-1000
         *              for d 1-1000
         *                  if(a^3 + b^3 = c^3 + d^3) print that
         * </pre>
         * O(N^4)
         * 
         * Remove unnecesary work: once found one solution for d, break the loop, since
         * only one solution will work.
         */

        equation(100);

    }

    public static void equation(int n) {
        Hashtable<Double, List<Object>> hashtable = new Hashtable<>();

        
        //If we initially have the first part of the equation and look for the pair.
        // and set it in a hashtable
        for (int c = 0; c < n; c++) {
            for (int d = 0; d < n; d++) {

                double result = Math.pow(c, 3) + Math.pow(d, 3);

                List<Object> list = hashtable.get(result);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new int[] { c, d });

                hashtable.put(result, list);

            }
        }

        //Avoid Duplicated Work:  we dont need to go over the 2-for iteration again

        // for (int a = 0; a < n; a++) {
        //     for (int b = 0; b < n; b++) {
        //         double result = Math.pow(a, 3) + Math.pow(b, 3);
        //         List<Object> list = hashtable.get(result);
        //         for (Object object : list) {
        //             int[] pair = (int[]) object;
        //             System.out.println(a + " + " + b + " = " + pair[0] + " + " + pair[1]);
        //         }
        //     }
        // }

        //Instead work over the hashtable with same values.
        Set<Double> keys = hashtable.keySet();
        for (Double key : keys) {
            List<Object> list = hashtable.get(key);

            for (Object pair1 : list) {
                int[] p1 = (int[]) pair1;

                for (Object pair2 : list) {
                    int[] p2 = (int[]) pair2;

                    System.out.println(p1[0] + " + " + p1[1] + " = " + p2[0] + " + " + p2[1]);
                }
            }
        }

        /* O(n^2) */
    }
}