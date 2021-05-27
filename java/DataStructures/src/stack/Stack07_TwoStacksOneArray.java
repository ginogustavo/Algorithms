package stack;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 * Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. Following functions must be supported by twoStacks.
 * push1(int x) –> pushes x to first stack
 * push2(int x) –> pushes x to second stack
 * pop1() –> pops an element from first stack and return the popped element
 * pop2() –> pops an element from second stack and return the popped element
 * Implementation of twoStack should be space efficient.
 */
public class Stack07_TwoStacksOneArray {

    int[] ARRAY = new int[20];
    int POINTER1, POINTER2, MID = 0;

    public void init(){
        //MID -> Starter point of stack 2
        if(ARRAY.length % 2 != 0){
            MID  = (ARRAY.length -1)/2;
        }else{
            MID  = ARRAY.length/2;
        }
        POINTER2 = MID;

    }

    public static void main(String[] args) {

        Stack07_TwoStacksOneArray app = new Stack07_TwoStacksOneArray();
        app.init();

        app.push1(100);
        app.push2(1000);
        app.push1(500);
        app.push2(5000);
        app.push1(700);
        app.push2(7000);
        app.push2(8000);
        app.push2(9000);
        app.push1(800);
        app.printArray();
        System.out.println(app.pop1());
        System.out.println(app.pop2());
        System.out.println(app.pop1());
        System.out.println(app.pop2());
        app.printArray();
    }


    public void push1(int val){
        ARRAY[POINTER1] = val;
        POINTER1++;
    }
    public void push2(int val){
        ARRAY[POINTER2] = val;
        POINTER2++;
    }

    public int pop1(){
        // 1. return the value
        // 2. delete the value of the point
        // 3. reduce pointer
        POINTER1--;
        int temp = ARRAY[POINTER1];
        ARRAY[POINTER1] = 0;
        return temp;
    }

    public int pop2(){
        POINTER2--;
        int temp = ARRAY[POINTER2];
        ARRAY[POINTER2] = 0;
        return temp;
    }

    public void printArray(){
        //Arrays.stream(ARRAY).forEach(System.out::print);
        for (int i = 0; i < ARRAY.length; i++) {
            String val = (ARRAY[i]==0)?" ":String.valueOf(ARRAY[i]);
            val = "["+i+"]= "+val; //+" | ";
            System.out.println(val);
        }
    }
}
