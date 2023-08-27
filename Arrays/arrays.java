import java.util.*;

public class arrays {
    
    public static void reverse(int num[]) {
        int first = 0, last = num.length - 1;
        while (first < last) {
            int temp = num[first];
            num[first] = num[last];
            num[last] = temp;
            first++;
            last--;
        }

    }

    public static void printSubarray(int num[]) {
        for (int i = 0; i < num.length; i++) {
            // Operation to get subarray starts from here
            for (int j = i; j < num.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(num[k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void maxSubarray(int num[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {
            // Accessing elements starts from here
            for (int j = i; j < num.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(num[k]);
                    currSum += num[k];
                }
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("the maximum subarray sum is : " + maxSum);
    }

    public static void kdanes_max_subArray(int num[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            currSum += num[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println(maxSum);

    }

    public static void trappingRainwater(int height[]) {
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        int n = height.length;
        // Calculate Maximum left boundary
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // Calculate Maximum right boundary
        int rightMax[] = new int[height.length];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - height[i]);
        }
        System.out.print("trapped water quantity is : " + trappedWater);
    }

    public static void buyAndSellStocks(int num[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < num.length; i++) {
            if (buyPrice < num[i]) {
                int profit = num[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = num[i];
            }
        }
        System.out.print("max profit is : " + maxProfit);

    }

    // ******************************* 2-D ARRAYS
    // *******************************************************

    // ************* SPIRAL MATRIX **********************

    public static void spiralMatrix(int matrix[][]) {

        int startRow = 0 , endRow = matrix.length - 1;
        int startCol = 0 , endCol = matrix[0].length - 1;
    
        while(startRow <= endRow && startCol <= endCol){
            // Top -  Boundary
            for(int i = startCol ; i<=endCol ; i++){
                System.out.print(matrix[startRow][i] + "  ");
            }

            // Right - Boundary
            for(int i = startRow+1 ; i<= endRow ;i++){
                System.out.print(matrix[i][endCol] + "  ");
            }

            // Bottom - Boundary
            for(int i = endCol - 1 ; i >= startCol; i--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][i] + "  ");
            }

            // Left - Boundary 
            for(int i = endRow -1 ; i>= startRow+1 ; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol] + "  ");
            }

            startRow++;    endRow--;
            startCol++;    endCol--;

        }
    }

    // ******* DIAGONAL SUM --->  Time Complexity - O(n)
        public static void diagonalSum(int matrix[][]){
            int sum = 0;
            for(int i = 0; i<matrix.length ;i++){
                // Primary diagonal
                sum += matrix[i][i];
                //Secondary diagonal
                if(i!=matrix.length-1-i){
                    sum +=  matrix[i][matrix.length-1-i];
                }
            }
            System.out.println("sum is : " + sum);
        }
    
        // Search in a Sorted Matrix  ----->   STAIRCASE SEARCH METHOD
        
        public static void staircaseSearch1(int matrix[][], int key){
            int row = 0 , col = matrix.length - 1;
            // Approaching from TOP - RIGHT corner 
            while(row < matrix.length  &&  col >= 0){
                if(matrix[row][col] == key){
                    System.out.print("found key at " + row + "," + col);
                    break;
                }
                else if(key < matrix[row][col]){
                    col--;
                }
                else{
                    row++;
                }
            }
            System.out.print("key not found ");
            
        }

        public static void staircaseSearch2(int matrix[][] , int key){
            int row = matrix.length - 1 , col = 0;
            // Approaching from BOTTOM - RIGHT corner
            while(row >= 0  &&  col < matrix[0].length){
                if(key == matrix[row][col]){
                    System.out.print("key is found at index : " + row + "," + col);
                    break;
                }
                else if(key < matrix[row][col]){
                    row--;
                }
                else{
                    col++;
                }
            }
        }

        // CHOCOLATE DISTRIBUTION PROBLEM
        public static int findMinDiff(int arr[],int n,int m){
            int min_diff = Integer.MAX_VALUE;
            if(n==0 || m==0){
                return -1;
            }
            if(n<m){
                return -1;
            }
            Arrays.sort(arr);
            for(int i=0;i+m-1<n;i++){
                int diff = arr[i+m-1] - arr[i];
                if(min_diff > diff){
                    min_diff = diff;
                }
            }
            return min_diff;
        }

        public static int removeDuplicates(int nums[]) {
            int iter = 0;
            while(iter<nums.length-1){
                if(nums[iter] == nums[iter+1]){
                    for(int j = iter;j<nums.length-1;j++){
                        nums[j] = nums[j+1];
                        nums[nums.length-1] = -1;
                    }
                }
                else{
                    iter++;
                }
            }
            int k = 0;
            for(int i = 0;i<nums.length;i++){
                if(nums[i] >= 0){
                    k++;
                }
                else{
                    break;
                }
            }
            return k;
        }


    public static void main(String args[]) {
    /*     Scanner sc = new Scanner(System.in);
        System.out.print("enter number of elements for array : ");
        int length = sc.nextInt();
        int num[] = new int[length];
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.print("Enter elements of array : ");
        for (int i = 0; i < length; i++) {
            num[i] = sc.nextInt();
        }

        */

        int matrix[][] = { { 1, 2, 3, 4 },{ 5, 6, 7, 8 },{ 9, 10, 11, 12 },{ 13, 14, 15, 16 } };

        // reverse(num);
        // for(int i=0;i<(num.length);i++){
        // System.out.print(num[i]+" "); }
        // printSubarray(num);
        // maxSubarray(num);
        // kdanes_max_subArray(num);
        // trappingRainwater(height);
        //buyAndSellStocks(num);
        //spiralMatrix(matrix);
        //diagonalSum(matrix);
        //staircaseSearch1(matrix, 7);
        // staircaseSearch2(matrix, 7);

        int arr[] = { 12, 4,  7,  9,  2,  23, 25, 41, 30,
            40, 28, 42, 30, 44, 48, 43, 50 };

        int m = 7; // Number of students

        int n = arr.length;
        // System.out.println("Minimum difference is "+ findMinDiff(arr, n, m));
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
