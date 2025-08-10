class Solution {
    public int numSquares(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp,Integer.MAX_VALUE);
       dp[0]=0;
       for(int i=1;i*i<=n;i++){
            int sq=i*i;
            for(int j=sq;j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-sq]+1);
            }
       }
       return dp[n];
    }
}