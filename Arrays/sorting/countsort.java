import java.util.*;
public class countsort{

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


    public static void main(String[] args) {
        int arr[] = {5,6,3,4,9,1,3,3,3,4,7};
        countSort(arr);
        for(int  i:arr){
            System.out.println(i);
        }
    }
}