import java.util.*;

public class lab3 {
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
 
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }

    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int key=arr[i]; //don't store index in key
            int j = i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }
    public static void duplicateElements(int arr[]){
        Arrays.sort(arr);
        int count = 0,freq = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                freq++;
            }
            else{
                freq = 0;
            }
            boolean t = (count>1)?true:false;
            if(t == true){
                count++;
            }
        }
        System.out.println(count);

    }
    public static void main(String[] args) {

        int arr[] = {4,2,2,2,6,5,5,6,5,7};
        // selectionSort(arr);
        // insertionSort(arr);
        duplicateElements(arr);
    }
}
