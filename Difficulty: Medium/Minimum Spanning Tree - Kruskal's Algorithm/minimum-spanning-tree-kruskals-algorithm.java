// User function Template for Java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Comparator<int[]> com=new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[2]<b[2])   return -1;
                else if(a[2]>b[2])  return 1;
                else    return 0;
            }
        };
        DSU dsu=new DSU(V);
        PriorityQueue<int[]> pq=new PriorityQueue<>(com);
        for(int[] edge:edges){
            pq.offer(edge);
        }
        int cost=0;
        while(!pq.isEmpty()){
            int[] graph=pq.poll();
            int u=graph[0];
            int v=graph[1];
            int w=graph[2];
            if(dsu.isConnected(u,v))    continue;
            dsu.union(u,v);
            cost+=w;
        }
        return cost;
    }
}

class DSU{
    private int[] parent;
    private int[] rank;
    
    public DSU(int size){
        parent=new int[size];
        rank=new int[size];
        
        for(int i=0;i<size;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y){
        int newX=find(x);
        int newY=find(y);
        if(newX==newY)    return;
        if(rank[newX]>rank[newY]){
            parent[newY]=newX;
        }else if(rank[newX]<rank[newY]){
            parent[newX]=newY;
        }else{
            parent[newY]=newX;
            rank[newX]++;
        }
    }
    
    public boolean isConnected(int x, int y){
        return find(x)==find(y);
    }
}
