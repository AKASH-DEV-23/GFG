class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        Comparator<int[]> com=new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[1]<b[1])   return -1;
                else if(a[1]>b[1])  return 1;
                else return 0;
            }
        };
        boolean[] visited=new boolean[V];
        PriorityQueue<int[]> pq=new PriorityQueue<>(com);
        pq.offer(new int[]{0,0});
        int cost=0;
        visited[0]=true;
        while(!pq.isEmpty()){
            int[] edge=pq.poll();
            int u=edge[0];
            int w=edge[1];
            if(!visited[u])
                cost+=w;
            visited[u]=true;
            for(int[] graph:adj.get(u)){
                if(!visited[graph[0]]){
                    pq.offer(graph);
                }
            }
        }
        return cost;
    }
}