class Solution {
    public int change(int amount, int[] coins) {
        int n=amount;
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=n;i++){
                
                dp[i]+=dp[i-coin];
            }
        }
        return dp[n];
    }
}