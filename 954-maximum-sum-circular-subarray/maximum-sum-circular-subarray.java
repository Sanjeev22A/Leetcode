class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=nums[0],minSum=nums[0],totalSum=nums[0];
        int max=nums[0],min=nums[0];

        for(int i=1;i<nums.length;i++){
            int a=nums[i];
            //System.out.println(a+":"+maxSum+":"+(maxSum+a)+":"+Math.max(a,maxSum+a));
            maxSum=Math.max(a,maxSum+a);
            max=Math.max(maxSum,max);
            minSum=Math.min(a,minSum+a);
            min=Math.min(minSum,min);
            totalSum+=a;
        }
        if(min==totalSum){
            return max;
        }
        //System.out.println(maxSum+":"+minSum);
        return Math.max(max,totalSum-min);
    }
}