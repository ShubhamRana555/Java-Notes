import java.util.*;

public class questions {
    // PUSH AN ELEMENT AT BOTTOM OF STACK
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

    // REVERSE A STRING USING STACK
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        // str = result.toString();  OR
        return result.toString();
    }

    // REVERSE A STACK
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return ;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    // STOCK SPAN PROBLEM
    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);

        }

    }

    // NEXT GREATER ELEMENT (RIGHT)
    public static void nextGreater(int arr[],int nextGreater[]){
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i] > arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }
            else{
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+"   ");
        }

    }

    //NEXT SMALLER ELEMENT
    public static void nextSmaller(int arr[],int nextSmaller[]){
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmaller[i] = -1;
            }
            else{
                nextSmaller[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<nextSmaller.length;i++){
            System.out.print(nextSmaller[i]+"   ");
        }
    }
    
    public static boolean validParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='['){
                s.push(str.charAt(i));
            }
            else{
                if(s.isEmpty()){
                    return false;
                }

                if(s.peek()=='(' && str.charAt(i)==')' || s.peek()=='{' && str.charAt(i)=='}' || 
                s.peek()=='[' && str.charAt(i)==']'){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean duplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for(int  i=0;i<str.length();i++){
            char ch = str.charAt(i);
            // closing bracket
            if(ch==')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count<1){
                    return true;
                }
            }
            else{
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int arr[]){
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        int maxArea = 0;
        // Getting next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            
            if(s.isEmpty()){
                nsr[i] = arr.length; //-1 will produce negative output in this case
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // Getting next smaller left
        s = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1; 
            }
            else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Calculating Area: width-> j-i-1 -> nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = width*height;
            maxArea = Math.max(maxArea,currArea);
        }
        System.out.println("area is : "+maxArea);

    }


    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(3);
        // s.push(4);
        // s.push(5);
        // s.push(6);
        // // pushAtBottom(s, 69);
        // while(!s.isEmpty()){
        //     System.out.print(s.pop()+"  ");
        // }

        // String str = "shubham";
        // String str1 = reverseString(str);
        // System.out.println(str1);

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // reverseStack(s);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop()+"  ");
        // }


        // int stocks[] = {100,80,60,70,60,85,100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for(int i=0;i<span.length;i++){
        //     System.out.print(span[i]+"  ");
        // }
  

        // int arr[] = {6,8,0,1,3};
        // int nextGreater[] = new int[arr.length];
        // int nextSmaller[] = new int[arr.length];
        // nextGreater(arr, nextGreater);
        // nextSmaller(arr, nextGreater);

        // String str = "((a+b)+c)";
        // System.out.println(validParenthesis(str));
        // System.out.println(duplicateParenthesis(str));
        
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
        

    }
}
 