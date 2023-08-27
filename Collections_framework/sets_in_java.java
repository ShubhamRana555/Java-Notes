import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
public class sets_in_java {
    public static void main(String[] args) {
        // HashSet does not maintain the order of element and prints elements in random order
        // HashSet is used to store unique occurrences of element(even if duplicates are present)
        // Set uses hashing internally and makes hashed for individual element.

        Set<Integer> set = new HashSet<>();

        set.add(34);
        set.add(34);
        set.add(2);
        set.add(4);
        set.add(89);

        System.out.println(set);
        set.remove(34);  // removes elements by value 
        System.out.println(set);

        System.out.println(set.contains(4));  // checks if a element is present in a set

        System.out.println(set.isEmpty());  // checks if set is empty or not

        System.out.println(set.size());  // size of set

        set.clear();  // removes all elements from a set
        System.out.println(set);

        // It arranges a set by following properties of a linkedlist  --> order is maintained
        Set<Integer> sl = new LinkedHashSet<>();
        sl.remove(34);  // can remove elements in between


        // It arranges elements in sorted order using binary search tree property
        // It also follow set property by storing unique elements
        Set<Integer> st = new TreeSet<>();




        // MAKING SET USING USER DEFINED DATATYPE
        class Student{
            String name;
            int rollno;

            Student(String name,int rollno){
                this.name = name;
                this.rollno = rollno;
            }
        }     
           





    }
}


