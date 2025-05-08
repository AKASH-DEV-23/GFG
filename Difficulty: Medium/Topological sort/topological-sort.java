//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends

// USING DFS --> Topological Sort

// class Solution {
//     static boolean[] visited;
//     static ArrayList<Integer> ans;
//     public static ArrayList<Integer> topoSort(int V, int[][] edges) {
//         // code here
//         Map<Integer,List<Integer>> map=new HashMap<>();
//         for(int edge[]:edges){
//             int u=edge[0];
//             int v=edge[1];
//             if(!map.containsKey(u)) map.put(u,new ArrayList<>());
//             map.get(u).add(v);
//         }
//         visited=new boolean[V];
//         ans=new ArrayList<>();
//         for(int i=0;i<V;i++){
//             if(!visited[i]) DFS(map,i);
//         }
//         Collections.reverse(ans);
//         return ans;
//     }
//     private static void DFS(Map<Integer, List<Integer>> map, int u){
//         visited[u]=true;
//         for(int v:map.getOrDefault(u,new ArrayList<>())){
//             if(!visited[v]) DFS(map,v);
//         }
//         ans.add(u);
//     }
// }

// USING BFS --> Kahn's Algo

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
       Map<Integer,List<Integer>> map=new HashMap<>();
       for(int[] edge:edges){
           int u=edge[0];
           int v=edge[1];
           if(!map.containsKey(u))  map.put(u,new ArrayList<>());
           map.get(u).add(v);
       }
       int[] inDegree=new int[V];
       for(int key:map.keySet()){
           for(int deg:map.get(key)){
               inDegree[deg]++;
           }
       }
       Queue<Integer> q=new LinkedList<>();
       for(int u=0;u<V;u++){
           if(inDegree[u]==0)   q.offer(u);
       }
       ArrayList<Integer> ans=new ArrayList<>();
       while(!q.isEmpty()){
           int u=q.poll();
           ans.add(u);
           for(int v:map.getOrDefault(u,new ArrayList<>())){
               inDegree[v]--;
               if(inDegree[v]==0)   q.offer(v);
           }
       }
       return ans;
    }
}