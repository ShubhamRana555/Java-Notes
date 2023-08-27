import java.util.ArrayList;

public class questions {

    // CONTAINER WITH MOST WATER (brute force approach)
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int width = j-i;
                int ht = Math.min(height.get(i),height.get(j));
                int currWater = width*ht;
                maxWater = Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }

    // CONTAINER WITH MOST WATER (two pointer approach)

    public static int twopointerstoreWater(ArrayList<Integer>height){
        int lp = 0;
        int rp = height.size()-1;
        int maxWater = 0;

        while(lp < rp){
            int width = rp - lp;
            int ht = Math.min(height.get(lp),height.get(rp));
            int currWater = width*ht;

            maxWater = Math.max(maxWater,currWater);

            // update pointer
            if(height.get(lp)>height.get(rp)){
                rp--;
            }
            else{
                lp++;
            }
        }
        return maxWater;
    }

    // Pair sum 1(find pair in a sorted array)
    public static boolean pairSum1(ArrayList<Integer> arr,int target){
        int lp = 0;
        int rp = arr.size()-1;

        while(lp != rp){
            //case1
            if(arr.get(lp)+arr.get(rp) == target){
                return true;
            }
            //case 2
            else if(arr.get(lp)+arr.get(rp) < target){
                lp++;
            }
            //case 3
            else{
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> arr,int target){
        int bp = -1;
        int lp,rp;
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i) > arr.get(i+1)){
                bp = i;
                break;
            }
        }

        //finding target
        int n = arr.size();
        lp = bp+1;
        rp = bp;
        while(lp != bp){
            if(arr.get(lp) + arr.get(rp) == target){
                return true;
            }
            else if(arr.get(lp) + arr.get(rp) < target){
                lp = (lp+1)%n;
            }
            else{
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        // System.out.println(storeWater(height));
        // System.out.println(twopointerstoreWater(height));

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.println(pairSum1(arr, 5));



    }
}
