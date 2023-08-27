// package Queue;
import java.util.*;

public class implemetation {
    /* 
    static class Queue{
        static int arr[];
        static int rear;
        static int size;
        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue overflow");
                return ;
            }
            rear = rear+1;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue underflow");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[0];
        }
        
    }
    */

    // QUEUE USING LINKED LIST
    /* 
    static class Queue{
        static int arr[];
        static int size;
        static int front , rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size==front;    
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("queue is full");
                return;
            }
            //add 1st element
            if(front==-1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int result = arr[front];

            //last element delete
            if(rear==front){
                rear = front = -1;
            }
            else{
                front = (front+1)%size;
            }
            return result;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[front];
        }
        */


        
        public static void main(String[] args) {
            Queue q = new Queue(4);
            q.add(3);
            q.add(2);
            q.add(5);               
            q.add(6);
    
            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }
        }
}
    

