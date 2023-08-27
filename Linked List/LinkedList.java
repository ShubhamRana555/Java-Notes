public class LinkedList {
    // CREATING A HEAD AND TAIL NODE
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;   //CONSTRUCTOR
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    
    // ADDING ELEMENT AT FIRST 
    public void addFirst(int data){
        // step1 - create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return ;
        }
        // step2 - Node next = head
        newNode.next = head;  // LINK
        // step3 - head = newNode
        head = newNode;
    }

    // ADDING ELEMENTS AT LAST
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return ;
        }
        tail.next = newNode; // LINK
        tail = newNode;

    }

    //  PRINTING ELEMENTS OF LINKED LIST
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -->  ");
            temp = temp.next; 
        }
        System.out.println("null");
    }

    public void addInMiddle(int idx , int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    
        public int removeFirst(){
            if(size == 0){
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            }
            else if(size == 1){
                int val = head.data;
                head = tail = null;
                return val;
            }
            int val = head.data;
            head = head.next;  size--;
            return val;
        }
    
        public int removeLast(){
            if(size == 0){
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            }
            else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
    
            Node prev = head;
            for(int i = 0; i < size - 2; i++){
                prev = prev.next;
            }
    
            int val = prev.next.data;  //tail.data
            tail = prev;
            prev.next = null;
            return val;
    
        }

        public void reverse(){
            Node prev = null;
            Node curr = tail = head;
            Node next;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev; // because linkedlist is reversed
        }
        
        void deleteNthNode(int n){
            // Nth from end --> size - N +1 from start
            // CALCULATE SIZE
            int sz = 0;
            Node temp = head;   
            while(temp!=null){
                temp = temp.next;
                sz++;
            }
            if(sz == n){//head is nth node
                head = head.next;
            }
            
            int i=1;
            int iToFind = sz-n;
            Node prev = head;
            while(i<iToFind){
                prev = prev.next;
                i++;
            }
            temp.next = temp.next.next;

        }

        // CHECK IF LINKEDLIST IS PALINDROME OR NOT
        public Node findMid(Node head){
            Node slow = head;
            Node fast = head;
            while(fast!=null || fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        } 

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();             // OBJECT
        // ll.head = new Node(1);             // 1 --> DATA
        // ll.head.next = new Node(2);

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addInMiddle(2,77);
        //ll.print();
        //ll.removeFirst();
        //ll.removeLast();
        //ll.print();
        //ll.reverse();
        ll.deleteNthNode(2);
        ll.print();
    }

    
    


}
