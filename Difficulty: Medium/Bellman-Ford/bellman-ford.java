// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist=new int[V];
        final int MAX=100_000_000;
        Arrays.fill(dist,MAX);
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(dist[u] != MAX && dist[u]+w < dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        boolean flag= false;
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(dist[u] != MAX && dist[u]+w<dist[v]){
                flag=true;
            }
        }
        if(flag){
            return new int[]{-1};
        }
        return dist;
    }
}
