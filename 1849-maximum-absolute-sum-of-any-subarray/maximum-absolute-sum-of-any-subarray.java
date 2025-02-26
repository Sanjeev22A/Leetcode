class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnding=nums[0];
        int minEnding=nums[0];
        int[] maxSum=new int[nums.length];
        int[] minSum=new int[nums.length];
        maxSum[0]=minSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            
            maxSum[i]=Math.max(maxSum[i-1]+nums[i],nums[i]);
            maxEnding=Math.max(maxSum[i],maxEnding);
            minSum[i]=Math.min(minSum[i-1]+nums[i],nums[i]);
            minEnding=Math.min(minSum[i],minEnding);
        }
        return Math.max(Math.abs(minEnding),maxEnding);
    }
}