import java.util.*;
public class strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a string : ");
        String str = sc.nextLine();
        String fruits[] = {"apple" , "mango","pineapple","guava"};
        //palindrome1(str);
        //System.out.print(getShortestPath(str));
        //largestString(fruits);
        toUppercase(str);     
    }

    // *************  PALINDROME STRING  ***************************************************************
    public static void palindrome1(String str){
        int count = 0;
        int n = str.length();
        for(int i=0 ; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                System.out.print("Not Palindrome !");
                count++;
                break;
            }
        }
        if(count == 0){
            System.out.print("Palindrome string !");
        }
    }


    // **************************  GET SHORTEST PATH  ************************************************************
    public static float getShortestPath(String str){
        int x = 0, y = 0;
        for(int i=0 ; i<str.length(); i++){
            char dir = str.charAt(i);
            // SOUTH DIRECTION
            if(dir == 's'){
                y--;
            }
            // NORTH DIRECTION
            else if(dir == 'n'){
                y++;
            }
            // WEST DIRECTION
            else if(dir == 'w'){
                x--;
            }
            // EAST DIRECTION
            else{
                x++;
            }

        }
        return (float)Math.sqrt((x*x) + (y*y));
    }
    
    //  ******************************  Largest String  ****************************************************
   
    public static void largestString(String fruits[]){
        String largest = fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(largest.compareTo(fruits[i]) < 0 ){
                largest = fruits[i];
            }   
        }
        System.out.print(largest);
    }

    // Converting first letter each word to uppercase
    public static void toUppercase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length()-1;i++){
            if(str.charAt(i)==' ' && i==(str.length()-1) ){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else if(str.charAt(i)==' '){
                sb.append(Character.toUpperCase(str.charAt(i+1)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        
        for(int i=0;i<sb.length();i++){
            System.out.print(str.charAt(i));
        }
    }



}
