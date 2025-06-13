class Solution {
    static int[][] dp=new int[1001][1001];
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(W,val,wt,0);
    }
    private static int solve(int w, int[] val, int[] wt, int idx){
        if(w<=0 || idx>=val.length)    return 0;
        if(dp[idx][w]!=-1) return dp[idx][w];
        int steal=0;
        if(w-wt[idx]>=0)
            steal=val[idx]+solve(w-wt[idx],val,wt,idx+1);
        int skip=solve(w,val,wt,idx+1);
        return dp[idx][w]=Math.max(steal,skip);
    }
}
