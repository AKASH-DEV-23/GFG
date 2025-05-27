class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i])
                topoSort(adj,i,st,visited);   
        }
        // System.out.println(st);
        Map<Integer,List<Integer>> reverseMap=new HashMap<>();
        for(int i=0;i<V;i++){
            reverseMap.put(i,new ArrayList<>());
        }
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                reverseMap.get(v).add(u);
            }
        }
        int component=0;
        // for(boolean flag:visited){
        //     if(!flag)   component++;
        // }
        Arrays.fill(visited,false);
        while(!st.isEmpty()){
            int u=st.pop();
            if(!visited[u]){
                DFS(reverseMap,u,visited);
                component++;
            }
        }
        return component;
    }
    private void DFS(Map<Integer,List<Integer>> reverseMap, int u, boolean[] visited){
        visited[u]=true;
        for(int v:reverseMap.get(u)){
            if(!visited[v]){
                DFS(reverseMap,v,visited);
            }
        }
    }
    private void topoSort(ArrayList<ArrayList<Integer>> adj, int u, Stack<Integer> st, boolean[] visited){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                topoSort(adj,v,st,visited);
            }
        }
        st.push(u);
    }
}