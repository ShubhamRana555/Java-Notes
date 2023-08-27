import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class stack_queue {
    public static void main(String[] args) {
        Stack<String>animals = new Stack<>();
        animals.push("deer");
        animals.push("peacock");
        animals.push("lion");
        animals.push("horse");
        System.out.println(animals);

        // peek() --> it will show the element present at stack top.
        System.out.println(animals.peek());

        // pop() --> it is used to delete topmost element in stack
        animals.pop();
        
        boolean val = animals.isEmpty();  // checks if stack is empty or not

        Queue<Integer> q = new LinkedList<>();
        // linkedlist is implementing queue interface

        q.offer(4); '''we can use "offer()" here it is slightly diffent from "add()" if add() do not insert a element it creates a exception'''
        q.offer(6);
        q.offer(24);
        q.offer(5);
        // add elements at last of queue


        q.poll();   // deletes the first element in queue
        System.out.println(q);

        // peek() --> it points at first element in queue
        System.out.println(q.peek());
    }
}
