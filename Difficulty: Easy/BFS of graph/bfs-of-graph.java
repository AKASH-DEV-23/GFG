class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> myQueue=new LinkedList<>();
        boolean[] visited=new boolean[adj.size()];
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(0);
        visited[0]=true;
        myQueue.offer(0);
        while(!myQueue.isEmpty()){
            int size=myQueue.size();
            for(int i=0;i<size;i++){
                int u=myQueue.poll();
                for(int v:adj.get(u)){
                    if(!visited[v]){
                        ans.add(v);
                        visited[v]=true;
                        myQueue.offer(v);
                    }
                }
            }
        }
        return ans;
    }
}