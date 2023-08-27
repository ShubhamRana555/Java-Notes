import java.util.*;

public class excercise {
    
    public static void palindrome(String str){
        int len = str.length();
        boolean res = true;
        for(int i=0;i<(len-1)/2;i++){
            if(str.charAt(i) != str.charAt(len-1-i)){
                res = false;
                break;
            }
        }
        if(res == true){
            System.out.println("Palindrome string");
        }
        else{
            System.out.println("not palindrome");
        }
    }

    public static float getShortestPath(String str){
        int x=0,y=0;
        int len = str.length();
        for(int i=0;i<len;i++){
            char ch = str.charAt(i);
            if(ch == 'e'){
                x++;
            }
            else if(ch == 'w'){
                x--;
            }
            else if(ch == 'n'){
                y++;
            }
            else{
                y--;
            }
        }    
        int X = x*x;
        int Y = y*y;
        float result =(float) Math.sqrt(X+Y);
        return result;
    }
    public static String largestString(String fruits[]){
        String largest = fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largest.compareTo(fruits[i])<0){
                largest = fruits[i];
            }
        }
        return largest;

    }

    public static String toUppercase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i< str.length(); i++){
            if(str.charAt(i)==' ' && i < str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        String rs = sb.toString();
        return rs;

    }

    public static String stringCompression(String str){
        String result = "";
        for(int i=0;i<str.length();i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            result += str.charAt(i);
            result += count.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        
        /* 
        String str1 = "hi";
        String str2 = "hi";
        String str3 = new String("hi");
        System.out.println(str1==str2);   //true
        System.out.println(str1==str3);   //false
        
        // while using "==", str1 and str3 are not equal because when we use "new" keyword to form a string then, a new memory is allocated to the string. But, when we don't use "new" keyword then, string will point to a already created memory location if two strings are same. So, str1 and str2 are equal and pointing to same memory location     but, not str1 and str3. 
        // TO COPE UP WITH THIS PROBLEM WE USE "str1.equals(str3)" function.
        
        System.out.println(str1.equals(str3));  //true
        */
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string : ");
        String str = sc.nextLine();
        //palindrome(str);
        //System.out.println(getShortestPath(str));    
        // System.out.println(str.substring(0,3)); //substring function

        String fruits[] = {"apple","APPLE"};
        // System.out.println(largestString(fruits));
        
        // System.out.println(toUppercase(str));
        
        System.out.println(stringCompression(str));


        


    }
    

}
