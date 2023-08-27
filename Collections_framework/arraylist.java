package Collections_framework;

import java.util.*;

public class arraylist {
    public static void main(String[] args) {
        /* List is a Class and other data structures like stack, arraylist , hashset etc. are interface of it. */

        /* Arraylist automatically increases it's size by n/2  once it is completely full it also comes with various additional features which are not available in static array. */
        List<Integer> list = new ArrayList();
        // ArrayList<Integer> arr = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // System.out.println(list);

        // Add elements in between ArrayList
        // list.add(index,element)
        list.add(2,56);
        // System.out.println(list);


        // Add two ArrayLists together
        List<Integer> newList = new ArrayList<>();
        newList.add(6);
        newList.add(9);
        newList.add(8);
        list.addAll(newList);
        System.out.println(list);


        // Access elements using index --> returns a value
        // list.get(index);
        // System.out.println(list.get(3));


        // remove an element using index
        // System.out.println(list.remove(3));
        // System.out.println(list);


        // remove an element using value
        // list.remove(DATA_TYPE.valueOf(value)); --> DATA_TYPE --> Wrapper Class
        list.remove(Integer.valueOf(56));
        System.out.println(list);

        // to delete complete list
        // list.clear();

        // replace one elements with another using index
        list.set(2,234);
        System.out.println(list);


        // To check if a element is present in list or not
        // list.contains(value) --> boolean
        System.out.println(list.contains(679));

        
        // iterating through every element in list
        for(int i = 0;i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
        System.out.println();

        for(Integer element:list){
            System.out.print(element+"  ");
        }

        
        // Iterator for every Interface in List
        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){   //hasNext() --> tells if next element is present or not
            // System.out.println(it.next() + "  ");
        }


        






    }
}
