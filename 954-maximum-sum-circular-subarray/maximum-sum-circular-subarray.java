class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=0;
        int curMax=Integer.MIN_VALUE;
        int minSum=0;
        int curMin=Integer.MAX_VALUE;
        int total=0;
        for(int a:nums){
            maxSum=Math.max(maxSum+a,a);
            curMax=Math.max(maxSum,curMax);
            minSum=Math.min(minSum+a,a);
            curMin=Math.min(minSum,curMin);
            total+=a;
        }
        if(curMax<0){
            return curMax;
        }
        return Math.max(total-curMin,curMax);
    }
}