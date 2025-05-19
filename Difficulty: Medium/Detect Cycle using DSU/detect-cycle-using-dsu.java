//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class DSU{
    private int[] parent;
    private int[] rank;
    public DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x){
        if(x==parent[x])    return x;
        return parent[x]=find(parent[x]);
    }
    public void union(int x, int y){
        int xParent=find(x);
        int yParent=find(y);
        if(xParent==yParent)    return;
        if(rank[xParent]>rank[yParent]){
            parent[yParent]=xParent;
        }else if(rank[xParent]<rank[yParent]){
            parent[xParent]=yParent;
        }else{
            parent[yParent]=xParent;
            rank[xParent]++;
        }   
    }
}
class Solution {
    // Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        DSU dsu=new DSU(V);
        for(int u=0;u<adj.size();u++){
            for(int v:adj.get(u)){
                if(u<v && dsu.find(u) == dsu.find(v)){
                    return 1;
                }else{
                    dsu.union(u,v);
                }
            }
        }
        return 0;
    }
}