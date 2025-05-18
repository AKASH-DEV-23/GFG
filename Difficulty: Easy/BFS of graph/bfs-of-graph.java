//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    boolean[] visited;
    ArrayList<Integer> ans;
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<adj.size();i++){
            map.put(i,new ArrayList<>());
            for(int v:adj.get(i)){
                map.get(i).add(v);
            }
        }
        visited=new boolean[adj.size()];
        ans=new ArrayList<>();
        BFS(map,0);
        return ans;
    }
    private void BFS(Map<Integer,List<Integer>> map, int st){
        Queue<Integer> q=new LinkedList<>();
        q.offer(st);
        visited[st]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            ans.add(u);
            for(int v:map.get(u)){
                if(!visited[v]){
                    q.offer(v);
                    visited[v]=true;
                }
            }
        }
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends