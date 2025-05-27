class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        int n=nums.length;
        dp[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            int max=0;
            for(int j=i+2;j<n;j++){
                max=Math.max(dp[j],max);
            }
            dp[i]=max+nums[i];
        }
        int res=0;
        for(int a:dp){
            res=Math.max(res,a);
        }
        return res;
    }
}