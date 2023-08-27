import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class sets_in_java {
    public static void main(String[] args) {
        // set is a collection of all duplicate elements
        // -> duplicates elements are not allowed
        // -> unordered and null values are allowed

        // HashSet is implemented using HashMap
        HashSet<Integer>set1 = new HashSet<>();    
        set1.add(1);    
        set1.add(1);    // it is not added to set
        set1.add(3);    
        set1.add(17);    
        set1.add(8);
        
        System.out.println(set1);

        // contains() --> if a element is present in a set or not
        System.out.println(set1.contains(2));

        // set1.clear(); //  deletes every value from a set


        // iterations in Set
        Iterator it = set1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("<------------------------------------------------------------>");
        System.out.println("Linked HashSet ......................");

        // implemented using Linked HashMap --> maintains insertion order of elements and use Double Linked List.
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        // Collections.sort(set2);  // it does not work on HashSet
        set2.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(5);
        System.out.println(set2);

        set2.remove(2);  // deletion can be done between elements
        System.out.println(set2);

        System.out.println("<------------------------------------------------------------->");
        System.out.println("Tree Set .....................................");
        // sorted elements in ascending order
        TreeSet<String>set3 = new TreeSet<>();
        set3.add("shubh");
        set3.add("nilesh");
        set3.add("mukesh");
        System.out.println(set3);


    }   
}
