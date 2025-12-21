class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=2;i--){
            min=Math.min(nums[i],min);
            if(min<nums[i-2]){
                return false;
            }
        }
        return true;
    }
}