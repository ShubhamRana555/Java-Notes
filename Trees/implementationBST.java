import java.util.ArrayList;

public class implementationBST {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Build a BST
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        
        if(root.data > val){
            root.left = insert(root.left,val);
        }
        else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + "  ");
        inOrder(root.right);

    }

    //search in BST
    public static boolean search(Node root,int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        else if(root.data > val){
            return search(root.left,val);
        }
        else{
            return search(root.right,val);
        }
    }
    

    //delete a node in BST
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root,int val){
        if(root.data > val){ 
            root.left = delete(root.left,val);
        }
        else if(root.data < val){
            root.right = delete(root.right,val);
        }
        else{ // root = data
            //leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            // one child
            if(root.left == null){
                return root.right;
            }
            if(root.left == null){
                return root.left;
            }

            //both childrens
            Node Is = findInorderSuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right,Is.data);
        }
        return root;

    }


    // print elements in given range
    public static void printInRange(Node root,int n1,int n2){
        if(root == null){
            return;
        }
        if(root.data >= n1 && root.data <= n2){
            printInRange(root.left,n1,n2);
            System.out.print(root.data + "  ");
            printInRange(root.left,n1,n2);
        }

        else if(root.data < n1){
            printInRange(root.left,n1,n2);
        }
        else{
            printInRange(root.right, n1, n2);
        }

    }


    // print path from root to leaf
    public static void printPath(ArrayList<Integer>path){
        for(Integer i:path){
            System.out.print(i+"  ");
        }
        System.out.println();
    }


    public static void root2Leaf(Node root,ArrayList<Integer> path){
        
        if(root == null){
            return ;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);           
        }
        root2Leaf(root.left, path);
        root2Leaf(root.right, path);
        path.remove(path.size()-1);
    }
    

    public static void main(String[] args) {
        // int values[] = {5,1,3,4,2,7};
        // Node root = null;
        // for(int i=0;i<values.length;i++){
        //     root = insert(root,values[i]);
        // }
        // inOrder(root);

        // System.out.println(search(root,7));
        

        // inOrder(root);
        // root = delete(root,5);  System.out.println();
        // inOrder(root);

        // printInRange(root, 3, 7);
        
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        

        // root2Leaf(root, new ArrayList<>());
        

    }
}
