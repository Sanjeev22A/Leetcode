class Solution {
    public int longestOnes(int[] nums, int k) {
        int length=0,maxLength=0;
        int slow=0,fast=0;
        int counter=0;
        while(fast<nums.length){
            if(nums[fast]==1){
                fast++;
            }
            else if(counter<k && nums[fast]==0){
                fast++;
                counter++;
            }
            else if(counter==k && nums[fast]==0){
                while(nums[slow]!=0){
                    slow++;
                }
                slow++;
                counter--;
            }
           
            
            length=fast-slow;
            maxLength=Math.max(length,maxLength);
        }
        return maxLength;
    }
}