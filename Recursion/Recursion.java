import java.util.*;

public class Recursion {

    public static void printDec(int n){
        if(n==1){   //Base Case
            System.out.println(n);
            return ;
        }
        System.out.println(n);
        printDec(n-1);
    }
    
    public static void printInc(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printInc(n-1);
        System.out.println(n);
    }

    public static int  factorial(int n){
        if(n==0){
            return 1;
        }
         factorial(n-1);
        int fact = n*factorial(n-1);
        return fact;
    }

    public static int fibonacci(int n){
        //base case
        if(n==1 || n==0){
            return n;
        }
        
        int fnm1 = fibonacci(n-1);
        int fnm2 = fibonacci(n-2);

        return (fnm1 + fnm2);
    }
    
    public static boolean isSorted(int arr[],int i){
        //base case
        if(i == arr.length - 1){
            return true;
        }

        //kaam...........
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
        
    }

    public static int firstOccurence(int arr[] , int key , int i ){
        //base case
        if(i == arr.length){
            return -1;
        }
        
        //kaam...........
        if(arr[i]==key){
            return i;
        }

        return firstOccurence(arr,key,i+1);
    }

    public static int lastOccurence(int arr[] , int key , int i){
        if(i  ==  arr.length){
            return -1;
        }

        int isFound = lastOccurence(arr, key, i+1);
        if(isFound != -1 ){
            return isFound;
        }
        
        if(arr[i] == key){
            return i;
        }
        return isFound;
    }
    
    public static int power1(int a , int n){
        if(n==0){
            return 1;
        }

        return a*power1(a, n-1);

    }

    public static int power2(int a , int n){
        if(n==0){
            return 1;
        }

        int halfPower = power2(a, n/2);
        int halfPowerSq = halfPower*halfPower;

        if(n%2 != 0){
            return a*halfPowerSq;
        }

        return halfPowerSq;
    }

    public static int tilingProblem(int n){
        //Base Case
        if(n == 0 || n == 1){
            return 1;
        }

        int totWays =  tilingProblem(n-1) + tilingProblem(n-2);
        return totWays;
    }

    public static void removeDupStrings(String str , boolean map[] , StringBuilder newStr  , int idx){
        //Base Case
        if(idx == str.length()){
            System.out.println(newStr);
            return ;
        }
        
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            // Duplicate
            removeDupStrings(str, map, newStr, idx+1); //Move to next index
        }
        else{
            map[currChar - 'a'] = true;
            newStr.append(currChar);
            removeDupStrings(str, map, newStr, idx+1);
        }
    }
    
    public static int friendsPairingProblem(int n){
        // base case
        if(n==1 || n==2){
            return n;
        }

        //Kaam
        //choice - single
        int fnm1 = friendsPairingProblem(n-1);

        // Pair
        int fnm2 = friendsPairingProblem(n-2);
        int pairWays = (n-1)*friendsPairingProblem(n-2);

        int totWays = fnm1 + pairWays;
        return totWays;
    }

    public static void binaryStrings(int n , int lastPlace , String str){
        // Base Case
        if(n == 0){
            System.out.println(str);
            return ;
        }
        
        if(lastPlace == 0){
        binaryStrings(n-1, 0, str + ("0"));
        binaryStrings(n-1, 1, str + ("1"));
        }
        else{
            binaryStrings(n-1, 0 , str + ("0"));
        }

        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("enter value of n : ");
        n = sc.nextInt();
        //printDec(n);
        //printInc(n);
        //System.out.println(factorial(n));
        //System.out.println(fibonacci(n));
        
        /* 
        int arr[] = new int[n];
        System.out.println("enter the elements of array : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        */


        //System.out.println(isSorted(arr, 0));
        //System.out.println(firstOccurence(arr, 6 , 0));
        //System.out.println(lastOccurence(arr, 5, 0));
        //System.out.println(power2(2 , 10));
        //System.out.println(tilingProblem(n));
        // boolean map[] = new boolean[26];
        // String str = "aap mumbai nahi aa sakte";
        //removeDupStrings(str,map, new StringBuilder(""), 0);
        binaryStrings(n, 0, " ");
    }     

}
