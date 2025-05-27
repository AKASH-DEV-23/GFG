// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int V=dist.length;
        for(int via=0;via<V;via++){
            for(int u=0;u<V;u++){
                for(int v=0;v<V;v++){
                    if(dist[u][via] != 100_000_000 && dist[via][v] != 100_000_000)
                        dist[u][v]=Math.min(dist[u][v],dist[u][via]+dist[via][v]);
                }
            }
        }
    }
}