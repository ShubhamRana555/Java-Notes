import java.util.*;
public class dsa1 {
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
        //float _a = sc.nextInt();  //IMPLICIT TYPE CONVERSION
        //int sum = (int) a;
        // float rad = sc.nextFloat();
        // float area = 3.14f * rad * rad ;  
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();
        // float avg = (float)(a+b+c)/3;  // EXPLICIT CONVERSION 
        
        //CALCULATE TAX ON INCOME
    //     int income = sc.nextInt();
    //     float tax ;
    //     if(income<500000){
    //         tax = income;
    //     }
    //     else
    //     if(income>=500000 && income<=1000000){
    //         tax = income*(0.2f);
    //     }
    //     else{
    //         tax = income*(0.3f);
    //     }
    //     System.out.print(tax);
     
    // ************************** CALCULATOR  ********************************************************
    /* 
    System.out.print("enter a operator to use : ");
    char operator = sc.next().charAt(0);
    System.out.println("enter value of two numbers : ");
    int a = sc.nextInt();
    int b = sc.nextInt();
    if(operator=='+'){
        System.out.print("the sum is : " + (a+b));
    }
    else
    if(operator=='-'){
        if(a>b){
            System.out.print(a-b);
        }
        else{
            System.out.print(b-a);
        }
    }
    else
    if(operator=='*'){
        System.out.print(a*b);
    }
    else
    if(operator=='/'){
        System.out.print(a/b);
    }
    else{
        System.out.print("invalid input");
    }
    */
    
    // ************ TO CHECK A LEAP YEAR *******************************************
    /* 
    int year = sc.nextInt();
    if(year%4==0 && year%100!=0 || year%400==0){
        System.out.print("Leap Year");
    }
    else{
        System.out.print("Not a Leap Year");
    }
    */

    // ************* PRINT REVERSE OF A NUMBER **********************************************
    /* 
    System.out.print("enter a number : ");
    int num = sc.nextInt();
    int result = 0 , rem = 0;
    while(num>0){
        rem = num % 10 ;
        num /= 10;
        result = (result*10) + rem;
    }
    System.out.print("reverse of the number is : " + result);  
    */
    
    // **************************** CHECK FOR A PRIME NUMBER ***************************************
    /* 
    System.out.print("enter value : ");
    int num = sc.nextInt();

    boolean isPrime = true;
    for(int i=2;i<=Math.sqrt(num);i++){
        if(num%i==0){
            isPrime = false;
        }
    }
    if(isPrime == true){
        System.out.print("Prime number");
    }
    else{
        System.out.print("Not a Prime number");
    }
    */

    /* 
    public static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact *= i;
        }
    return fact;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("nter the values of n and r : ");
        int n = sc.nextInt();
        int r = sc.nextInt();
        int bio_coeff = factorial(n)/(factorial(r)*factorial(n-r));
        System.out.print(bio_coeff);
    
    }
    */
    // TO CHECK FOR A PRIME NUMBER ---->  EFFICIENT CODE
    /* 
    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter value of  n : ");
        int n = sc.nextInt();
        System.out.print(isPrime(n));
    }
    */
    
    // ********************** BINARY TO DECIMAL CONVERSION *************************************
    /* 
    public static void binToDec(int binNum){
        int decNum = 0, pow =0;
        while(binNum > 0){
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int)Math.pow(2,pow));
            pow++;
            binNum /= 10;
        }
        System.out.print("decimal number is : " + decNum);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number : ");
        int n = sc.nextInt();
        binToDec(n);
    }
    */

    // ************************ DECIMAL TO BINARY CONVERSION **************************************** 

    public static void decToBin(int decNum){
        int pow = 0 , binNum = 0 , rem = 0;
        while(decNum>0){
            rem = decNum % 2;
            binNum = binNum + (rem * (int)Math.pow(10,pow));
            pow++;
            decNum /= 2;
        }
        System.out.print("binary number is : " + binNum);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number : ");
        int n = sc.nextInt();
        decToBin(n);
    }

}                   