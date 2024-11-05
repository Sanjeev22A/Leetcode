class Solution {
    public int longestSubarray(int[] nums) {
        int length=0,maxLength=0;
        int slow=0,fast=0;
        int counter=0;
        while(fast<nums.length){
            if(nums[fast]==1){
                fast++;
            }
            else if(counter<1 && nums[fast]==0){
                fast++;
                counter++;
            }
            else if(counter==1 && nums[fast]==0){
                while(nums[slow]!=0){
                    slow++;
                }
                slow++;
                counter=0;
            }
           
            
                length=fast-slow-Math.max(counter,1);
            maxLength=Math.max(length,maxLength);
        }
        return maxLength;
    }
}