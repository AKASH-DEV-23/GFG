class Pair{
    int vertex;
    int weight;
    public Pair(int vertex, int weight){
        this.vertex=vertex;
        this.weight=weight;
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        Map<Integer,List<Pair>> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            map.get(u).add(new Pair(v,w));
            map.get(v).add(new Pair(u,w));
        }
        
        Comparator<Pair> com=new Comparator<>(){
            public int compare(Pair p1, Pair p2){
                if(p1.weight < p2.weight)   return -1;
                else if(p1.weight > p2.weight)  return 1;
                else return 0;
            }
        };
        
        PriorityQueue<Pair> pq=new PriorityQueue<>(com);
        int[] distance=new int[n+1];
        int[] parent=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1]=0;
        parent[1]=1;
        pq.offer(new Pair(1,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.vertex;
            if(curr.weight>distance[u])     continue;
            for(Pair neighbour:map.get(u)){
                int v=neighbour.vertex;
                int cost=neighbour.weight;
                if(distance[u]+cost<distance[v]){
                    distance[v]=distance[u]+cost;
                    parent[v]=u;
                    pq.offer(new Pair(v,distance[v]));
                }
            }
        }
        
        List<Integer> list=new ArrayList<>();
        if(distance[n]==Integer.MAX_VALUE){
            list.add(-1);
            return list;
        }
        
        int node=n;
        while(node!=parent[node]){
            list.add(node);
            node=parent[node];
        }
        list.add(1);
        Collections.reverse(list);
        list.add(0,distance[n]);
        return list;
    }
}