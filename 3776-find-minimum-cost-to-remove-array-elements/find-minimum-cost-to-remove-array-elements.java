class Solution {
    int[][] dp;
    int cost(int prev,int curIndex,int[] nums){
        
        if(curIndex==nums.length){
            return nums[prev];
        }else if(curIndex==nums.length-1){
            return Math.max(nums[prev],nums[curIndex]);
        }
        else{
            if(dp[curIndex][prev]==-1){
                int a=Math.max(nums[prev],nums[curIndex])+cost(curIndex+1,curIndex+2,nums);
                int b=Math.max(nums[prev],nums[curIndex+1])+cost(curIndex,curIndex+2,nums);
                int c=Math.max(nums[curIndex],nums[curIndex+1])+cost(prev,curIndex+2,nums);
                dp[curIndex][prev]=Math.min(a,Math.min(b,c));
                return dp[curIndex][prev];
            }else{
                return dp[curIndex][prev];
            }
            
        }
    }
    public int minCost(int[] nums) {
        dp=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return cost(0,1,nums);
    }
}