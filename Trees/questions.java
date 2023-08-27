import java.util.*;
public class questions {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    static class binaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //PreOrder Traversal
        public static void preOrder(Node root){
            if(root == null){
                return ;
            }
            System.out.print(root.data+"  ");
            preOrder(root.left);
            preOrder(root.right);
        }
        //Inorder Traversal
        public static void inOrder(Node root){
            if(root == null){
                return ;
            }
            inOrder(root.left);
            System.out.print(root.data+"  ");
            inOrder(root.right);
        }
        //Postorder Traversal
        public static void postOrder(Node root){
            if(root == null){
                return ;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+"  ");
        }

        // Level Order Traversal
        public static void levelOrder(Node root){
            if(root == null){
                return ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+"  ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }

        }
        //height of tree
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh,rh) + 1;
        }
        //count number of nodes
        public static int count(Node root){
            if(root == null){
                return 0;
            }
            int lh = count(root.left);
            int rh = count(root.right);

            return lh + rh + 1;

        }
        //sum of nodes
        public static int sum(Node root){
            if(root == null){
                return 0;
            }
            int lh = sum(root.left);
            int rh = sum(root.right);

            return lh + rh + root.data;
        }

        //diameter of a tree
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftDiam = diameter(root.left);
            int leftht = height(root.left);
            int rightDiam = diameter(root.right);
            int rightht = height(root.right);

            int selfDiam = leftht + rightht + 1;
            return Math.max(selfDiam , Math.max(leftDiam,rightDiam));
        }
    }
        
    // subtree of another tree
    public static boolean isIdentical(Node root,Node subroot){
        if(root==null){
            return true;
        }
        else if(root==null || subroot==null || root.data!=subroot.data){
            return false;
        }

        // for left and right subtree
        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root,Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Kth level of a tree
    public static void KthLevel(Node root,int level,int k){
        if(root == null){
            return;
        }
        if(level==k){
            System.out.print(root.data+"  ");
        }
        KthLevel(root.left, level+1, k);
        KthLevel(root.right, level+1, k);
    }

    // lowest common ancestor
    public static Node lca(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data ==  n2){
            return root;
        }
        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);
        
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

    // Minimum distance between nodes
    // Approach -->  find distance of values from lca, then add the distance
    public static int lcaDist(Node lca,int n){
        if(lca == null){
            return -1;
        }
        if(lca.data == n){
            return 0;
        }

        int left = lcaDist(lca.left,n);
        int right = lcaDist(lca.right,n);

        if(left == -1 && right == -1){
            return -1;
        }        
        if(left == -1){
            return right + 1;
        }
        if(right == -1){
            return left + 1;
        }
        return 0;
    }
    
    public static int minDist(Node root,int n1,int n2){
        if(root == null){
            return -1;
        }
        Node lca = lca(root,n1,n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1 + dist2;
    }

    // Transform to Sum Tree
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        
        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + newRight + leftChild + rightChild;
        
        return data;
    }
    public static void preOrder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+"  ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree = new binaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);

        // System.out.println(height(root));
        // System.out.println(tree.count(root));
        // System.out.println(tree.sum(root));

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println(tree.diameter(root));

        //subtree
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // System.out.println(isSubtree(root,subRoot));

        // KthLevel(root,1,2);

        // System.out.println(lca(root,6,7).data);

        // System.out.println(minDist(root, 4, 5));

        transform(root);
        preOrder(root);



    }    
}
