class Solution {
    int ways(int[] nums,int currentIndex,int curVal,int target){
        if(currentIndex==nums.length){
            if(curVal==target){

                return 1;
            }
            return 0;
        }
        return ways(nums,currentIndex+1,curVal+nums[currentIndex],target)
            + ways(nums,currentIndex+1,curVal-nums[currentIndex],target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums,0,0,target);
    }
}