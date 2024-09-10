class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean flag=false;
        int i=0;
        while(i<nums.length-1){
            if(nums[i]%2==nums[i+1]%2){
                return false;
            }
            i++;
        }
        return true;
    }
}