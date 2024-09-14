class Solution {
    public int longestSubarray(int[] nums) {
        int count=0,maxValue=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(maxValue<nums[i]){
                maxValue=nums[i];
            }
        }
        int length=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxValue){
                count++;
                length=Math.max(length,count);
            }
            else{
                count=0;
            }
        }
        return length;
    }
}