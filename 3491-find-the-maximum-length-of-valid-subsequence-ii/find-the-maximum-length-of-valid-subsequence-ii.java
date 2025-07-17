class Solution {
    int[][] dp;
    
    public int maximumLength(int[] nums, int k) {
        int n=nums.length;
        dp=new int[n][k];
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            
            for(int j=0;j<i;j++){
                int cur=(nums[i]+nums[j])%k;
                if(dp[j][cur]==0){
                    dp[i][cur]=Math.max(dp[i][cur],2);
                }else{
                    dp[i][cur]=Math.max(dp[j][cur]+1,dp[i][cur]);
                }
                maxLen=Math.max(dp[i][cur],maxLen);
            }
            
        }
        return maxLen;
    }
}