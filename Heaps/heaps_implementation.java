
import java.util.ArrayList;

public class heaps_implementation {
    static class Heap{
        // Implementing MIN Heap
        ArrayList<Integer> arr = new ArrayList<>();
        
        // insert operation in Heap
        public void add(int data){
            arr.add(data);
            
            int x = arr.size()-1;  //index of new added data
            int par = (x-1)/2;  // index of parent --> x = (2 * i) + 1
            
            while(arr.get(x) < arr.get(par)){  // JUST REVERSE THIS CONDITION TO IMPLEMENT MAX HEAP
                // swap parent and child
                int temp = arr.get(x);
                arr.set(x,arr.get(par)); // arr.set(index,value)
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }

        }

        // peek operation in Heap
        public int peek(){
            return arr.get(0);
        }

        
        // delete operation in Heap
        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(left) < arr.get(i)){
                minIdx = left; 
            }
            if(right < arr.size() && arr.get(right) < arr.get(i)){
                minIdx = i;
            }

            if(minIdx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx); // to rearrange heap for next parent
            }

        }

        public int remove(){
            int data = arr.get(0);

            // swap first and last element of ArrayList
            int temp = data;
            arr.set(0 , arr.get(arr.size()-1));
            arr.set(arr.size()-1 , temp);

            // delete last element of Heap
            arr.remove(arr.size()-1);

            heapify(0);

            return data;

        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }


    }


    // HEAP SORT
    public static void buildHeap(int arr[],int i,int n){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < n && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < n && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            buildHeap(arr, maxIdx, n);
        }


    }

    public static void heap_sort(int arr[]){
        // step - 1 --> build Max Heap
        int n = arr.length;
        for(int i = n/2 - 1 ; i>=0 ; i--){
            buildHeap(arr,i,n);
        }

        // push largest to the end
        for(int i = n-1;i > 0; i--){
            // swap the first and last elements
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // rearrange the heap
            buildHeap(arr,0,i);
        }


    }


    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(29);
        pq.add(57);
        pq.add(867);
        pq.add(-1);

        // while(!pq.isEmpty()){
        //     System.out.print(pq.peek() + "   ");
        //     pq.remove();
        // }

        int arr[] = {4,3,6,2,1,7,8};
        heap_sort(arr);
        for(int i:arr){
            System.out.print(i + "  ");
        }

    }


}
