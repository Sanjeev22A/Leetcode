class Solution {
    public int subsequence(int i, List<Integer> nums, int target, int[][] dp){
        if(target==0) return 0;
        if(target<0 || i>=nums.size()) return Integer.MIN_VALUE;
        if(dp[i][target]!=-1) return dp[i][target];
        int skip = subsequence(i+1,nums,target,dp);
        int take = 1 + subsequence(i+1,nums,target-nums.get(i),dp);
        return dp[i][target] = Math.max(skip,take);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()+1][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++) dp[i][j] = -1;
        }
        int ans = subsequence(0,nums,target,dp);
        if(ans<=0) return -1;
        return ans;
    }
}