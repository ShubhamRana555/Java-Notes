import java.util.*;
public class bitwise_operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter value of n : ");
        int n = sc.nextInt();
        oddOrEven(n);
    }

    public static void oddOrEven(int n){
        if((n&1) == 0){
            System.out.print("even number");
        }
        else{
            System.out.print("odd number");
        }
    }

    
}
