class Solution {
    public int maxSubArray(int[] nums) {
        int maxEnding=nums[0];
        int ans=maxEnding;
        for(int i=1;i<nums.length;i++){
            maxEnding=Math.max(maxEnding+nums[i],nums[i]);
            ans=Math.max(maxEnding,ans);
        }
        return ans;
    }
}