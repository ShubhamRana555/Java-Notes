import java.util.*;
public class intro {
    public static void main(String[] args) {
        /*
        Add element -> O(1)
        Get element -> O(1)
        Remove element -> O(n)
        Set element at index -> O(n)
        Contains element -> O(n)
        */
/* 
        ArrayList<Integer> list = new ArrayList<>();
        // add element
        list.add(2);
        list.add(3);
        list.add(5);
        
        list.add(1,4546); //list.add(index,value)
        // System.out.println(list);
        
        // get element
        int element = list.get(1);
        // System.out.println(element);
        
        // remove element
        int index = 2;
        list.remove(index);
        // System.out.println(list);
        
        // set element
        list.set(2,123);
        // System.out.println(list);
        
        // sorting arraylist
        Collections.sort(list);
        // System.out.println(list);

        Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);

*/

        // MULTI DIMENSIONAL ARRAYLIST
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list.add(list1);
        list.add(list2);

        for(int i=0;i<list.size();i++){
            ArrayList<Integer> currList = list.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+"  ");
            }
            System.out.println();
        }



    }
}
