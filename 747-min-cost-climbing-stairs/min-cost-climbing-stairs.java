class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        int n=cost.length;
        dp[n]=0;
        dp[n-1]=cost[n-1];
        for(int i=n-2;i>=0;i--){

            dp[i]=Math.min(dp[i+1],dp[i+2])+cost[i];
        }
        return Math.min(dp[0],dp[1]);
    }
}