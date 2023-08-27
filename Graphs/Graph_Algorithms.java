import java.util.PriorityQueue;
import java.util.ArrayList;


public class Graph_Algorithms {
    
    static class Edge {
        int wt, src, dest;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void  createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));



    }
    
    
    // Dijkstra's Algorithm (using priority queue) --> shortest path from source to all vertices 
    static class Pair implements Comparable<Pair>{
        int index,pathWt;
        Pair(int a,int b){
            this.index = a;
            this.pathWt = b;
        }

        public int compareTo(Pair p2){
            return this.pathWt - p2.pathWt;
        }
    }
    

    public static void dijkstra(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i != src)
            dist[i] = Integer.MAX_VALUE;
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.index]){
                vis[curr.index] = true;
                for(int i=0;i<graph[curr.index].size();i++){
                    Edge e = graph[curr.index].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;  //destination weight

                    if(dist[u] + wt < dist[v]){
                        dist[v] = wt + dist[u];
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }

        // print source to all vertices path
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + "  ");
        }

    }

    // Bellman Ford's Algorithm
    public static void bellmanFord(ArrayList<Edge>graph[],int src){
        int dist[] = new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // vis[] array is not required as we are visiting all vertices
        int V = graph.length;

        for(int i=0;i<V-1;i++){
            //traversing through all vertices
            for(int j=0;j<V;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }

        }

        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i]);
        }

    }




    
    
    
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);
        // dijkstra(graph,0);
        bellmanFord(graph, 0);
    }
    
}
