import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph_traversals {
    static class Edge {
        int wt, src, dest;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*
         * graph[0].add(new Edge(0,1,5));
         * graph[0].add(new Edge(0,2,3));
         * 
         * 
         * graph[1].add(new Edge(1, 0, 5));
         * graph[1].add(new Edge(1, 3, 3));
         * 
         * 
         * graph[2].add(new Edge(2, 0, 3));
         * graph[2].add(new Edge(2, 4, 1));
         * 
         * 
         * graph[3].add(new Edge(3, 1, 3));
         * graph[3].add(new Edge(3, 4, 2));
         * graph[3].add(new Edge(3, 5, 2));
         * 
         * 
         * graph[4].add(new Edge(4,2,1));
         * graph[4].add(new Edge(4,3,2));
         * graph[4].add(new Edge(4,5,7));
         * 
         * graph[5].add(new Edge(5,3,2));
         * graph[5].add(new Edge(5,4,7));
         * graph[5].add(new Edge(5,6,1));
         * 
         * graph[6].add(new Edge(6,5,1));
         */

        // for cycle in directed graphs
        /*
         * graph[0].add(new Edge(0,2,1));
         * graph[0].add(new Edge(0,1,1));
         * 
         * graph[1].add(new Edge(1,3,1));
         * 
         * graph[2].add(new Edge(2,3,1));
         */

        // Topological Sorting
        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));

        graph[3].add(new Edge(3, 1, 0));

        graph[2].add(new Edge(2, 3, 0));

    }

    // breadth first search
    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                vis[curr] = true;
                System.out.println(curr + "  ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }   

            }
        }

    }

    // depth first search with explicit stack
    public static void dfs1(ArrayList<Edge> graph[]) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[graph.length];

        st.push(0);

        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!vis[curr]) {
                vis[curr] = true;
                System.out.println(curr + "   ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    st.push(e.dest);
                }
            }
        }
 
    }

    // depth first search with implicit stack
    public static void dfs2(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        // visit
        System.out.println(curr + "  ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs2(graph, e.dest, vis);
            }
        }

    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }

        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest]) {
                if (hasPath(graph, e.dest, dest, vis)) {
                    return true;
                }
            }

        }

        return false;
    }

    // Connected Componenets --> BFS
    public static void bfsConnected(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]) {
        // BFS logic here ................
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                vis[curr] = true;
                System.out.println(curr + "  ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
    }

    // Connected Componenets --> DFS
    public static void dfsConnected(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i])
                dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // dfs logic here ....................
        System.out.println(curr + "  ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs2(graph, e.dest, vis);
            }
        }
    }

    // detect cycle in undirected graphs
    public static boolean detectCycle1(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (vis[e.dest] && e.dest != par) {
                return true;
            }
        }

        return false;

    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                col[i] = 1;
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }

    // detect cycle in Directed Graphs
    public static boolean isCycle2(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycle2_Util(graph, vis, stack, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle2_Util(ArrayList<Edge> graph[], boolean vis[], boolean stack[], int curr) {
        vis[curr] = true;
        stack[curr] = true; // stack for checkin loop by checkin neighbour of current node

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vis[e.dest] && isCycle2_Util(graph, vis, stack, e.dest)) {
                return true;
            }
        }
        stack[curr] = false; // empty the stack
        return false;
    }

    // Topological Sort using DFS
    public static void topologicalSortdfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortdfs_util(graph, vis, st, i);
            }
        }       
        while (!st.isEmpty()) {
            System.out.println(st.pop() + "  ");
        }
    }
    public static void topologicalSortdfs_util(ArrayList<Edge> graph[], boolean vis[], Stack<Integer> st, int curr) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalSortdfs_util(graph, vis, st, e.dest);
            }
        }
        st.push(curr);
    }

    // Topological Sort using BFS --> Kahn's Algorithm
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topologicalSortbfs(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph,indeg);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.println(curr + "  ");

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest] --;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }    
            }
        }

    }

    public static void printAllPath(ArrayList<Edge> graph[],int src,int dest,String path){
        if(src == dest){
            System.out.println(path + dest);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPath(graph,e.dest,dest,path + src);
        }
    }



    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // bfs(graph);
        // dfs1(graph);

        // dfs2(graph,0,new boolean[graph.length]);

        // System.out.println(hasPath(graph,0,5,new boolean[V]));

        // bfsConnected(graph);

        // dfsConnected(graph);

        // System.out.println(detectCycle1(graph));

        // System.out.println(isBipartite(graph));
        // System.out.println(isCycle2(graph));

        // topologicalSortdfs(graph);
        // topologicalSortbfs(graph);


        int src = 5, dest = 1;
        printAllPath(graph,src,dest," ");





    }
}
