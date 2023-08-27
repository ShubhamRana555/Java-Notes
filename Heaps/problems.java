import java.util.PriorityQueue;

public class problems {
    static class points implements Comparable<points>{
        int x,y;
        int distSq,idx;
        points(int x,int y,int distSq,int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(points obj2){ // sort in ascending order
            return this.distSq - obj2.distSq;
        }
    }

    // Given location of N cars in 2D plane. Find nearest cars if we are at origin
    public static void nearbyCars(int pts[][],int k){
        PriorityQueue<points> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new points(pts[i][0], pts[i][1], distSq, i)); // pushing objects in priority queue 
        }

        // nearest k cars
        for(int i=0;i<k;i++){
            System.out.println(pq.remove().idx);
        }
    }

    // Connect N ropes into one single larger rope
    public static void nRopes(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]); // adding elements to queue
        }

        int cost=0;
        while(pq.size() > 1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }
        System.out.println(cost);
    }


    // Weakest Soldiers
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;
        Row(int soldiers,int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row obj){
            // if number of soldiers equal then compare with index
            if(obj.soldiers == this.soldiers){
                return this.idx - obj.idx;
            }
            else{
                return this.soldiers - obj.soldiers;
            }
        }
    }


    public static void weakestSoldier(int army[][],int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0;i<army.length;i++){
            //count number of soldiers
            int count = 0;
            for(int j=0;j<army[i].length;j++){
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count,i));
        }

        while(k > 0){
            System.out.println(pq.remove().idx);
            k--;
        }


    }


    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        // nearbyCars(pts, k);
        
        int ropes[] = {2,3,3,4,6};
        // nRopes(ropes);

        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};

        weakestSoldier(army, 2);

         
    }
    
}
