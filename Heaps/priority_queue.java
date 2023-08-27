
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class priority_queue {
    
    // public static void main(String[] args) {
    //     PriorityQueue<Integer>pq1 = new PriorityQueue<>(); // MIN Priority  Queue
    //     PriorityQueue<Integer>pq2 = new PriorityQueue<>(Comparator.reverseOrder()); // MAX Priority  Queue

    //     pq1.add(2);
    //     pq1.add(7);
    //     pq1.add(4);
    //     pq1.add(1);

    //     pq2.add(2);
    //     pq2.add(7);
    //     pq2.add(4);
    //     pq2.add(1);

    //     while(!pq1.isEmpty()){
    //         System.out.print(pq1.peek() + "  "); // gives element at 0th index of priority queue
    //         pq1.remove();
    //     }
    //     System.out.println();
    //     while(!pq2.isEmpty()){
    //         System.out.print(pq2.peek() + "  ");
    //         pq2.remove();
    //     }


    //     System.out.println();

    // }


    // PRIORITY QUEUE FOR OBJECTS
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Collections.reverseOrder());  // max priority queue
        pq.add(new Student("shubh", 234));
        pq.add(new Student("rohit", 100));
        pq.add(new Student("rahul", 1034));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "     rank --> " + pq.peek().rank);
            pq.remove();
        }

    }


}
