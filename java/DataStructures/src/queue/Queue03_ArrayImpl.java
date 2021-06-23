package queue;

public class Queue03_ArrayImpl {




    public static void main(String[] args) {

        MyQueue mq = new MyQueue(4);
        mq.enqueue(10);
        mq.enqueue(20);
        mq.enqueue(30);
        mq.enqueue(40);

        mq.dequeue();

        System.out.println( "front: "  +  mq.front());
        System.out.println("rear: " + mq.rear() );
    }


}

class MyQueue{
    int front, rear, capacity, size;
    int[] array;

    public MyQueue(int capacity){
        this.capacity = capacity;
        this.array = new int[this.capacity];
        this.front = this.size = 0;
        // Important rear
        this.rear = capacity - 1;
    }

    public boolean isFull(){
        return this.capacity == this.size;
    }

    public boolean isEmpty(){
        return this.size == 0 ;
    }

    public int front(){
        if (isEmpty()) return Integer.MIN_VALUE;
        return this.array[this.front];
    }
    public int rear(){
        if (isEmpty()) return Integer.MIN_VALUE;
        return this.array[this.rear];
    }

    public void enqueue(int value){
        if(isFull()) return;
        this.rear = ( this.rear + 1 ) % capacity;
        this.array[this.rear] = value;
        this.size++;
        System.out.println(value + " was enqueued.");
    }

    public void dequeue(){
        if(isEmpty()) return;

        int retrieved_value = this.array[this.front];
        this.front = (this.front + 1 ) % capacity;
        this.size--;

        System.out.println(retrieved_value +  " was dequeued.");
    }
}
