//{ Driver Code Starts
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
            boolean ans = obj.isBipartite(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(!map.containsKey(u)) map.put(u,new ArrayList<>());
            if(!map.containsKey(v)) map.put(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int[] color=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(isBipartiteBFS(map,i,color,1)==false)    return false;
            }
        }
        return true;
    }
    private boolean isBipartiteBFS(Map<Integer,List<Integer>> map, int u, int[] color,int currColor){
        color[u]=currColor;
        Queue<Integer> q=new LinkedList<>();
        q.offer(u);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int v:map.getOrDefault(curr,new ArrayList<>())){
                if(color[v]==color[curr])   return false;
                else if(color[v]==-1){
                    color[v]=1-color[curr];
                    q.offer(v);
                }
            }
        }
        return true;
    }
}