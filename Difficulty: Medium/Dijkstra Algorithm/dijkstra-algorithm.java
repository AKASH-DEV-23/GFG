// User function Template for Java

class Pair{
     int vertex;
     int weight;
    public Pair(int vertex, int weight){
        this.vertex=vertex;
        this.weight=weight;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        Map<Integer,List<Pair>> map=new HashMap<>();
        for(int i=0;i<V;i++){
            map.put(i,new ArrayList<>());
        }
        
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            map.get(u).add(new Pair(v,w));
            map.get(v).add(new Pair(u,w));
        }
        
        Comparator<Pair> com=new Comparator<>(){
            public int compare(Pair p1, Pair p2){
                if(p1.weight<p2.weight)     return -1;
                else if(p1.weight>p2.weight)    return 1;
                else    return 0;
            }
        };
        
        PriorityQueue<Pair> pq=new PriorityQueue<>(com);
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.vertex;
            int w=curr.weight;
            for(Pair neighbour:map.get(u)){
                int v=neighbour.vertex;
                int cost=neighbour.weight;
                if(w+cost<distance[v]){
                    distance[v]=w+cost;
                    pq.offer(new Pair(v,cost+w));
                }
            }
        }
        return distance;
    }
}