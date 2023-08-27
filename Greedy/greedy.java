
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class greedy {
    
    // Activity Selection
    public static ArrayList<Integer> activitySelection(ArrayList<Integer> res,int start[],int end[]){
        int maxAct = 0;

        res.add(0);
        maxAct++;
        int lastEnd = end[0];

        for(int i=1;i<end.length;i++){
            if(start[i] >= lastEnd){
                maxAct++;
                res.add(i);
                lastEnd = end[i];
            }
        }

        return res;
    }
    
    // Activity Selection --> If start[] is sorted in place of end[]. we have to sort in end time by using 2D matrix
    public static void activitySelection1(int start[],int end[]){
        int activities[][] = new int[start.length][3];
        for(int i=0;i<activities.length;i++){ //creating a matrix
            activities[i][0] = i;             // index at 0 column
            activities[i][1] = start[i];      // elements of start[] at 1 column
            activities[i][2] = end[i];        // elements of end[] at 2 column
        }

        // SORT THE MATRIX ON BASIS OF END[] ARRAY
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));


        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        int count = 1;
        int lastEnd = end[0];

        for(int i=1;i<start.length;i++){
            if(lastEnd <= activities[i][1]){
                count++;
                res.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        for(int i:res){
            System.out.print(i + "  ");
        }

    }

    // FRACTIONAL KNAPSACK
    public static void fractionalKnapsack(int val[],int weight[],int w){
        double ratio[][] = new double[val.length][2];
        // 0th column --> index    1st column --> ratio

        for(int i=0;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        // Ascending Order on basis of ratio
        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));

        int finalVal = 0;
        
        for(int i=ratio.length-1;i>=0;i--){ // cause sort on ascending order ratio as parameter
            int idx = (int)ratio[i][0];

            if(w >= weight[idx]){
                finalVal += val[idx];
                w -= weight[idx];
            }
            else{
                finalVal += (ratio[i][1]*w) ;
                w = 0;
                break;
            }
        }
        System.out.println("total value is : " + finalVal);

    }

    public static void minAbsoluteDiff(int a[],int b[]){
        int minDiff = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0;i<a.length;i++){
            minDiff += Math.abs(a[i]-b[i]);
        }
        System.out.println(minDiff);
    }


    // Maximum Length Chain of Pairs
    public static void ChainPairs(int arr[][]){
        Arrays.sort(arr,Comparator.comparingDouble(o -> o[1])); // sorted on basis of end time

        int chainLen = 1;
        int prevChainEnd = arr[0][1];

        for(int i=1;i<arr.length;i++){
            if(arr[i][0] >= prevChainEnd){
                chainLen++;
                prevChainEnd = arr[i][1];
            }
        }
        System.out.println("length of chain : " + chainLen);

    }


    // Indian Coins
    public static void indianCoins(int arr[],int amount){
        //  WE CAN'T USE "Comparator.reverseOrder()" ON "INT". SO WE ARE CONVERTING OUR ARRAY TO "Integer" DATATYPE.
        Integer []coins = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            coins[i] = arr[i];
        }



        Arrays.sort(coins,Comparator.reverseOrder()); // sort in descending order
        ArrayList<Integer> res = new ArrayList<>();

        int no_of_coins = 0;
        for(int i=0;i<coins.length;i++){
            while(amount >= coins[i]){
                no_of_coins++;
                amount -= coins[i];
                res.add(coins[i]);
            }
        }

        System.out.println("no. of coins : " + no_of_coins);
        System.out.println(res);


    }


    // job Sequencing Problem  --> using class
    static class Job{
        int id;
        int deadline;
        int profit;

        Job(int id,int dead,int pro){
            this.id = id;
            this.profit = pro;
            this.deadline = dead;
        }

    }

    public static void jobSequencingProblem1(int arr[][]){
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0;i<jobs.size();i++){
            jobs.add(new Job(i, arr[i][0], arr[i][1]));
        }

        // Sort the objects
        Collections.sort(jobs,(obj1,obj2) -> obj2.profit - obj1.profit);  // descending order
        // Collections.sort(jobs,(obj1,obj2) -> obj1.profit - obj2.profit);  // ascending order

        int time = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);

            if(curr.deadline > time){
                time++;
                res.add(curr.id);
            }

        }

        System.out.println("max no. of jobs: " + res.size());
        System.out.println(res);

    }

    public static void jobSequencingProblem2(int arr[][]){
        ArrayList<ArrayList<Integer>> jobs = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<jobs.size();i++){
            jobs.add(new ArrayList<>());
            jobs.get(i).add(i);
            jobs.get(i).add(arr[i][0]);  // deadline
            jobs.get(i).add(arr[i][1]);  // profit
        }

        // Sort the objects
        for(int i=0;i<jobs.size();i++){
            Collections.sort(jobs.get(i));
        }

        int time = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            ArrayList<Integer> curr = jobs.get(i);

            if(curr.get(1) > time){
                time++;
                res.add(curr.get(0));
            }

        }

        System.out.println("max no. of jobs: " + res.size());
        System.out.println(res);
    }


    // Choclola Problem
    public static void chocolaProblem(Integer costHor[],Integer costVer[]){
        Arrays.sort(costHor,Collections.reverseOrder());
        Arrays.sort(costVer,Collections.reverseOrder());

        int hor_iter = 0, ver_iter = 0;
        int hor_pieces = 1, ver_pieces = 1;

        int cost = 0;
        
        while(hor_iter < costHor.length && ver_iter < costVer.length){
            if(costHor[hor_iter] <= costVer[ver_iter]){
                cost += (costVer[ver_iter] * hor_pieces);
                ver_iter++; 
                ver_pieces++;
            }
            else{
                cost += (costHor[hor_iter] * ver_pieces);
                hor_iter++;
                hor_pieces++;
            }

        }

        //for remaining pieces
        while(hor_iter < costHor.length){
            cost += (costHor[hor_iter] * ver_pieces);
            hor_pieces++;
            hor_iter++;
        }
        while(ver_iter < costVer.length){
            cost += (costVer[ver_iter] * hor_pieces);
            ver_pieces++;
            ver_iter++;
        }

        System.out.println("cost : " + cost);

    }




    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        // ArrayList<Integer>res = new ArrayList<>();
        // activitySelection(res, start, end);
        // for(int i:res){
        //     System.out.print(i + "  ");
        // }

        
        // activitySelection1( start, end);

        // int val[] = {60,100,120};
        // int weight[] = {10,20,30};
        // fractionalKnapsack(val, weight, 50);


        // int a[] = {1,2,4};
        // int b[] = {10,2,1};
        // minAbsoluteDiff(a, b);


        // int pairs[][] = {{5,24},{3,60},{5,28},{27,40},{50,90}};
        // ChainPairs(pairs);

        
        // int coins[] = {1,2,5,10,20,50,100,500,2000};
        // indianCoins(coins, 590);

        int jobs[][] = {{4,20},{1,10},{1,40},{1,30}};
        // jobSequencingProblem1(jobs);
        // jobSequencingProblem2(jobs);
        

        Integer costHor[] = {3}; /*{4,1,2};*/
        Integer costVer[] =  {2}; /*{2,1,3,1,4};*/

        chocolaProblem(costHor, costVer);


        

    }    
}
