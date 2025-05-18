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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends

        // USING DFS
        
// class Solution {
//     boolean[] visited;
//     boolean[] isRecurrsion;
//     public boolean isCyclic(int V, int[][] edges) {
//         // code here
//         Map<Integer,List<Integer>> map=new HashMap<>();
//         for(int[] edge:edges){
//             int u=edge[0];
//             int v=edge[1];
//             if(!map.containsKey(u)) map.put(u,new ArrayList<>());
//             map.get(u).add(v);
//         }
//         visited=new boolean[V];
//         isRecurrsion=new boolean[V];
//         for(int i=0;i<V;i++){
//             if(!visited[i] && isCycle(map,i)) return true;
//         }
//         return false;
//     }
//     private boolean isCycle(Map<Integer,List<Integer>> map, int u){
//         visited[u]=true;
//         isRecurrsion[u]=true;
//         for(int v:map.getOrDefault(u,new ArrayList<>())){
//             if(visited[v]==false && isCycle(map,v)) return true;
//             else if(isRecurrsion[v])    return true;
//         }
//         isRecurrsion[u]=false;
//         return false;
//     }
// }


      // USING BFS KAHN'S ALGORITHM
      
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
       Map<Integer, List<Integer>> map=new HashMap<>();
       for(int edge[]:edges){
           int u=edge[0];
           int v=edge[1];
           if(!map.containsKey(u))  map.put(u,new ArrayList<>());
           map.get(u).add(v);
       }
       int cnt=0;
       int[] inDegree=new int[V];
       for(int key:map.keySet()){
           for(int val:map.get(key))
                inDegree[val]++;
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<V;i++){
           if(inDegree[i]==0){
                q.offer(i);
                cnt++;
           }
       }
       while(!q.isEmpty()){
           int u=q.poll();
           for(int v:map.getOrDefault(u,new ArrayList<>())){
               inDegree[v]--;
               if(inDegree[v]==0){
                   q.offer(v);
                   cnt++;
               }
           }
       }
       return cnt==V ? false : true;
    }
}