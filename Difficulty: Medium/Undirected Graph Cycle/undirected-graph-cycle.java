//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends




class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Map<Integer,List<Integer>> map=new HashMap<>();
        int u=0;
        for(int[] graph:edges){
            u=graph[0];
            int v=graph[1];
            if(!map.containsKey(u)) map.put(u,new ArrayList<>());
            if(!map.containsKey(v)) map.put(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i] && bfs(map,i,visited)){
                return true;
            }
        }
        return false;
    }
    private boolean DFS(Map<Integer,List<Integer>> map, int u, boolean[] visited, int parent){
        visited[u]=true;
        if(!map.containsKey(u)) map.put(u,new ArrayList<>());
        for(int v: map.get(u)){
            if(v==parent)   continue;
            if(visited[v])  return true;
            if(DFS(map,v,visited,u))    return true;
        }
        return false;
    }
    class Pair{
        int source;
        int parent;
        Pair(int source, int parent){
            this.source=source;
            this.parent=parent;
        }
    }
    private boolean bfs(Map<Integer,List<Integer>> map, int u, boolean[] visited){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(u,-1));
        visited[u]=true;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Pair p=q.poll();
                int source=p.source;
                int parent=p.parent;
                if(!map.containsKey(source))    map.put(source,new ArrayList<>());
                for(int v:map.get(source)){
                    if(visited[v]==false){
                        q.offer(new Pair(v,source));
                        visited[v]=true;
                    }else if(v!=parent){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}