// import java.util.ArrayList;

public class implementation {

//     static class stack{
//         static ArrayList<Integer> list = new ArrayList<>();
//         public static boolean isEmpty(){
//             return list.size()==0 ;
//         }
//         // push
//         public static void push(int data){
//             list.add(data);
//         }
//         // pop
//         public static int pop(){
//             if(isEmpty()){
//                 return -1;
//             }
//             int top = list.get(list.size()-1);
//             list.remove(list.size()-1);
//             return top;
//         }
//         public static int peek(){
//             if(isEmpty()){
//                 return -1;
//             }
//             else{
//                 return list.get(list.size()-1);
//             }
//         }
//     }


    // public static void main(String[] args) {
    //     stack s = new stack();
    //     s.push(23);
    //     s.push(34);
    //     System.out.println(s.peek());
    // }    

//  -----------------------  STACK USING LINKED LIST  ---------------------------
    static class Node{
        int data; Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack{
        static Node head = null;
        public static boolean isEmpty(){
            return head==null;
        }
        // PUSH
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return ;
            }
            newNode.next = head;
            head = newNode;
        }
        // POP
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        // PEEK
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(3);
        s.push(5);
        s.push(7);
        while(!s.isEmpty()){
            System.out.println(s.peek()+"  ");
            s.pop();
        }
    }




}
