
import java.util.*;

import java.util.HashMap;

public class maps_in_java {
    static class test implements Comparable<test>{
        // not  able to implement it properly where keys are objects in HashMap.
        String key;
        int rank;

        test(String key,int rank){
            this.key = key;
            this.rank = rank;
        }

        @Override
        public int compareTo(test obj){
            return obj.rank - this.rank;
        }
    }
    public static void main(String[] args) {
        HashMap<test,Integer>mapk = new HashMap<>();
        mapk.put(new test("shubh",1),23);
        mapk.put(new test("adarsh",34),45);
        mapk.put(new test("mukesh",111),33);
        System.out.println(mapk);


        // Hashmaps in java
        // Hashmaps are used to store (key,value) pair unorderly where keys are always unique.
        HashMap<String,Integer> map1 = new HashMap<>();
        
        // put() --> it is used to assign (key,value) pair to HashMap
        map1.put("shubh",19);
        map1.put("adarsh",16);
        map1.put("rahul",17);

        
        // get(key) --> it takes key as input and returns value
        System.out.println(map1.get("shubh"));

        // remove(key) --> it is used to remove a (key,value) pair form HashMap
        map1.remove("rahul");  // it's return type is a value
        
        System.out.println(map1); 

        System.out.println(map1.isEmpty());

        // Iteration in HashMap
        System.out.println("making array of keys .............");
        Set<String> keys = map1.keySet();  // it is a array of keys in which we can traverse to perfrom various operations

        System.out.println("keys are : " + keys);

        for(String k:keys){
            System.out.println(map1.get(k) + "   ");
        }


        System.out.println("<----------------------------------------------> ");


        // Linked HashMap --> It is used to store (Key,value) pair in order of insertion done. It is implemented using Double Ended Queue.
        System.out.println(" Linked HashMaps in Java ...................");
        LinkedHashMap<Integer,String> map2 = new LinkedHashMap<>();
        map2.put(1,"mukesh");
        map2.put(2,"suresh");
        map2.put(3,"ramesh");
        map2.put(4,"bhupesh");

        System.out.println(map2);

        // if we print map2 then (key,value) pair will be printed in the order in which (key,value) pair are inserted.
        
        map2.remove(2);  // we can delete the pairs in between of the map2.
        System.out.println(map2);

        
        System.out.println("<---------------------------------------------->");
        System.out.println("TreeMap in Java .........................");
        // It stores the (key,value) pair in the ascending order of the keys in sorted order.
        //get() --> it takes O(logn) time to rearrange pairs in sorted order.

        TreeMap<Integer,String>map3 = new TreeMap<>();
        map3.put(1,"mukesh");
        map3.put(2,"suresh");
        map3.put(10,"ramesh");
        map3.put(4,"bhupesh");

        System.out.println(map3);

        
    }
}
