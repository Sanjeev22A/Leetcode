class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right=0,left=0,minLength=Integer.MAX_VALUE;
        int currentSum=0;
        for(right=0;right<nums.length;right++){
            currentSum+=nums[right];
            while(currentSum>=target){
                currentSum-=nums[left];
                minLength=Math.min(minLength,right-left+1);
                left++;
            }
        }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}