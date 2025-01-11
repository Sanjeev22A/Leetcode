class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            dp[i]=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>max){max=dp[i];}
        }
        return max;
    }
}