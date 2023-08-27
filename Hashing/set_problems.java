import java.util.HashSet;
import java.util.HashMap;

public class set_problems {

    // count distinct elements
    public static void countDistinctElements(int ele[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<ele.length;i++){
            set.add(ele[i]);
        }
        System.out.println(set.size());
    }

    // union and intersection of arrays
    public static void unionIntersection(int arr1[],int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        // union of arrays
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println("no. of elements in union : " + set.size());

        // intersection of arrays
        set.clear();

        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("no. of elements in intersection : " + count);

    }

    // Find Itinerary from Tickets
    public static String startingPoint(HashMap<String,String>tickets){
        HashMap<String,String>revMap = new HashMap<>();
        for(String k:tickets.keySet()){
            revMap.put(tickets.get(k),k);
        }

        for(String k:tickets.keySet()){
            if(!revMap.containsKey(k)){
                return k;  //starting point
            }
        }
        return null;
    
    }

    public static void findItinerary(HashMap<String,String>tickets){
        String start = startingPoint(tickets);
        System.out.println(" -> " + start);
        for(String k:tickets.keySet()){
            System.out.println(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }

    // Maximum subarray with sum 0
    public static void subarraySum0(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0,len = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }

        System.out.println("length of largest subarray is : " + len);

    }


    // Maximum subarray sum equal k
    public static void subarraySumk(int arr[],int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //corner case

        int sum = 0,len = 0;
        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                len += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        System.out.println(len);


    }

    public static void main(String[] args) {
        int ele[] = {4,3,2,5,6,7,3,4,2,1};
        // countDistinctElements(ele);

        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        // unionIntersection(arr1,arr2);

        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("chennai","bengaluru");
        tickets.put("mumbai","delhi");
        tickets.put("goa","chennai");
        tickets.put("delhi","goa");
        // findItinerary(tickets);

        int arr[]  = {15,-2,2,-8,1,7,10,23};
        // subarraySum0(arr);

        int ar[] = {1,2,3};
        int k = 3;
        subarraySumk(ar,k);





    }
}
