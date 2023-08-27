import java.util.*;
import java.util.LinkedList;
public class questions {
    
    // FIRST NON REPEATING CHARACTER IN STREAM OF CHARACTERS
    public static void nonRepeating(String str){
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            //deleting repeated characters
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+"  ");
            }
            else{
                System.out.print(q.peek()+"  ");
            }

        }


    }

    // INTERLEAVE TWO HALVES OF QUEUE
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        
        // splitting queue in two halves
        for(int i=0;i<size/2;i++){
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }


    }

    // REVERSE A QUEUE
    public static void reverseQueue(Queue<Integer>q){
        Stack<Integer>helper = new Stack<>();
        int size = q.size();
        //addng elements to stack
        for(int i=0;i<size;i++){
            helper.push(q.remove());
        }
        //addng elements to queue
        while(!helper.isEmpty()){
            q.add(helper.pop());
        }
    }


    public static void main(String[] args) {
        String str = "aabccxb";
        // nonRepeating(str); 

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        // interLeave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+"  ");
        }
        reverseQueue(q);
        


    }
}
