import java.util.*;
public class sorting_advanced{

    public static void countSort(int arr[]){
        int n = arr.length;
        int max=0;  // maximum element in array
        for(int i=0;i<n;i++){
            max = Math.max(arr[i],max);
        }

        int freq[] = new int[max+1];   //frequency array
        for(int i=0;i<n;i++){
            freq[arr[i]]++;
        }

        // prefix sum of frequency array
        for(int i=1;i<max+1;i++){
            freq[i] += freq[i-1];
        }

        // replace elements based on sorted order using original array from end
        int res[] = new int[n];
        for(int i = n-1;i>=0;i--){
            res[--freq[arr[i]]] = arr[i];
        }

        for(int i=0;i<n;i++){
            arr[i] = res[i];
        }

    }

    // Dutch National Flag Algorithm
    public static void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void dnf(int nums[]){
        int start=0;
        int curr=0;
        int end=nums.length-1;

        while(curr <= end){
            if(nums[curr] == 0){
                swap(nums,curr,start);
                curr++;
                start++;
            }
            else if(nums[curr] == 2){
                swap(nums,curr,end);
                end--;
            }
            else{
                curr++;
            }
        }

    }

    //Merge Sort
    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,6,3,4,9,1,3,3,3,4,7};
        // countSort(arr);
        // for(int  i:arr){
        //     System.out.println(i);
        // }
        int nums[] = {0,2,2,1,1,2,1,0,0};
        dnf(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
        mergeSort(arr, 0, arr.length - 1);
    }
}
    

 