package problems.math;

public class GreatCommonDivisor {
    public static void main(String[] args) {
        // get the great common divisor of 2 numbers
        // ex. 12, 3 = 3

        System.out.println(new GreatCommonDivisor().gcd(12,4));
    }

//    private static int gcd(int a, int b){
//        if(b==0)return a;
//        else return gcd(b,a%);
//    }
    /*Fuction to get gcd of a and b*/
    int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
