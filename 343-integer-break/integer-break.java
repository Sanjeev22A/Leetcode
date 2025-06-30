class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            int val=0;
            for(int j=1;j<i;j++){
                val=Math.max(val,j*Math.max(dp[i-j],i-j));
            }

            dp[i]=val;
        }
        return dp[n];
    }
}