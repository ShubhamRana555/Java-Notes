
import java.util.ArrayList;

public class Adjacency_list {
    // Create a list using Adjacency List
    static class Edge{
        int wt,src,dest;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    
    public static void main(String[] args) {
        /* 
        0        4
         \      /
          1 ---2  
           \  /  
            3
        */

        int V = 5;
        ArrayList<Edge> []graph = new ArrayList[V];
        // "null" is strored to every index of ArrayList initally and then after initialising, it becomes a empty ArrayList.

        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,5));


        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));


        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));


        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(1, 4, 2));

        graph[4].add(new Edge(4, 2, 2));

        

        // 2's neighbours
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest + " --> " + e.wt);
            // System.out.println(graph[2].get(i).dest);
        }



    }
}
