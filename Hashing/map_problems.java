import java.util.HashMap;
import java.util.Set;

public class map_problems {

    // Majority Element
    public static void majorityElement(int arr[]){
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
        //     if(map.containsKey(arr[i])){
        //         map.put(arr[i],map.get(arr[i])+1);
        //     }
        //     else{
        //         map.put(arr[i],1);
        //     }
        
        map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        // this line can be used to replace the if - else condition above.
        // here "getOrDefault()" is used to return the value in the key "arr[i]" otherwise it returns zero.

        }

        // making a array of keys
        Set<Integer>keys = map.keySet();

        for(Integer i:keys){
            if(map.get(i) > arr.length/3 ){
                System.out.println(i);
            }
        }

    }


    // Valid Anagrams
    public static boolean validAnagrams(String s,String t){
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char k = s.charAt(i);
            // if(map.containsKey(k)){
            //     map.put(k,map.get(k) + 1);
            // }
            // else{
            //     map.put(k,1);
            // }

            map.put(k,map.getOrDefault(k, 0) + 1);
        }

        // delete every pair in map by comparing with string t
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.get(ch) - 1);
                }
            }
            else{
                return false;
            }
        }

        return map.isEmpty();

    }

    public static void main(String[] args) {
        // int arr[] = {1,3,2,5,1,3,1,5,1};
        // majorityElement(arr);

        String s = "race",t = "care";
        // System.out.println(validAnagrams(s, t));

    }
    
}
