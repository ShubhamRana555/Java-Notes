import java.util.*;
/* 
public class ASSIGNMENTS {
    // ********************** ARRAYS **************************************************************************
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter size of array : ");
        int n = sc.nextInt();   
        int num[] = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();  
        }
        int matrix[][] = {{1,2,3,4} , {5,6,7,8}}; 
        //buyAndSellStocks(num);
        //trappedRainwater(num);
        transposeMatrix(matrix);
    }
    // Question - 3 
    public static void buyAndSellStocks(int num[]){
        int n = num.length-1;
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(buyPrice < num[i]){
                int profit = num[i] - buyPrice;
                maxProfit = Math.max(profit,maxProfit); 
            }
            else{
                buyPrice = num[i];
            }
        }
        System.out.print("maximum profit is : " + maxProfit);
    }
    // Question - 4
    public static void trappedRainwater(int num[]){
        int n = num.length;
        //Left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = num[0];
        for(int i=1 ; i<n ; i++){
            leftMax[i] = Math.max(num[i],leftMax[i-1]);
        }

        //Right Max Boundary
        int rightMax[] = new int[n];
        rightMax[n-1] = num[n-1];
        for(int i = n-2; i>=0; i--){
            rightMax[i] = Math.max(num[i],rightMax[i+1]);
        }
        int trappedWater = 0;
        for(int i=0;i<n;i++){
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            trappedWater += waterLevel - num[i];
        }
        System.out.print("trapped water is : " + trappedWater);
    }


    // ****************************  2 - D  ARRAYS  ********************************************
    // Question - 3 
    public static void transposeMatrix(int matrix[][]){
        int transpose[][] = new int[matrix[0].length-1][matrix.length-1];
        for(int i = 0 ;i < matrix[0].length ;i++){
            for(int j=0 ; j<matrix.length ; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        for(int i = 0 ; i<transpose.length; i++){
            for(int j=0;j<transpose[0].length ; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
*/

//  ***************  Object Oriented Programming **********************************************
// Question - 1
public class ASSIGNMENTS{
    public static void main(String[] args) {
        
    }
}
class Complex{
    void sum(int ar , int ac , int br , int bc){

    }
    void difference(int ar , int ac , int br , int bc){
        
    }
    void product(int ar , int ac , int br , int bc){
        
    }
}
