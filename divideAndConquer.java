import java.util.*;
public class divideAndConquer {
    
    public static void mergeSort(int arr[] ,int si ,int ei){
        //base case
        
        if(si >= ei){
            return ;
        }
        int mid = si +(ei - si)/2 ;
        mergeSort(arr, si , mid);   // FOR LEFT SIDE SUBARRAY
        mergeSort(arr, mid+1 ,ei);  // FOR RIGHT SIDE SUBARRAY
        merge(arr, si, mid , ei); // TO MERGE TWO SUBARRAYS
    }
    
    public static void merge(int arr[] , int si ,int mid , int ei){
        int temp[] = new int[ei - si +1];
        int i = si;          // iterator for left part
        int j = mid + 1;     //  iterator for right part
        int k = 0;           //  iterator for temp[] array
        while(i<=mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++ ; k++;
            }
            else{
                temp[k++] = arr[j++];
            }
            
        }
        //left part remaining elements
        while(i<=mid){
            temp[k++] = arr[i++];    
        }
        //right part remaining elements
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        // copy temp[] to original array
        for(k=0 , i=si; k<temp.length; k++,i++ ){
            arr[i] = temp[k];
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[6]  ;
        System.out.println("enter values of array : ");
        for(int i=0; i<6; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0 , 5);        

        for(int i=0;i<6;i++){
            System.out.println(arr[i]);
        }
    }
}

