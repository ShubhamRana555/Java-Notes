import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayDeque;


public class priority_queue_arraydeque {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();  // min priority queue  --> min heap
        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());      // max priority queue  --> max heap
        
        pq1.offer(45);
        pq1.offer(11);
        pq1.offer(23);
        pq1.offer(4);
        pq1.offer(5);

        // System.out.println(pq1);

        pq1.poll();  // deletes minimum element form min heap and maximum element from max heap

        // System.out.println(pq1);
        // System.out.println(pq1.peek()); // show maximum element in max heap and minimum element in min heap



        /* Array Deque --> It implements a queue in which insertion and deletion can be done from both front and rear ends. It implements queue */

        ArrayDeque<Integer> ad = new ArrayDeque<>();

        ad.offer(34);  // add elements at last --> this proper came from queue
        ad.offerLast(23); // add elements at last  --> this property comes from ArrayDeque
        ad.offerFirst(12);  // add elements at First --> this property comes from ArrayDeque

       System.out.println(ad);

        System.out.println(ad.peek());  // gives the first element in queue
        System.out.println(ad.peekFirst());  // gives first element in queue
        System.out.println(ad.peekLast());   // gives last element in queue

        System.out.println(ad.poll());  // deletes first element from queue
        System.out.println(ad);

        System.out.println(ad.pollFirst());  // deletes first element from queue
        System.out.println(ad);

        System.out.println(ad.pollLast());  // deletes last element from queue
        System.out.println(ad);

    }
}
