class Solution {
    public int minimumCost(int[] nums) {
        Integer[][] suffixMin=new Integer[nums.length][2];
        suffixMin[nums.length-1][0]=null;
        suffixMin[nums.length-1][1]=null;
        suffixMin[nums.length-2][0]=nums[nums.length-1];
        suffixMin[nums.length-2][1]=null;
        suffixMin[nums.length-3][0]=Math.min(nums[nums.length-2],suffixMin[nums.length-2][0]);
        suffixMin[nums.length-3][1]=Math.max(nums[nums.length-2],suffixMin[nums.length-2][0]);
        for(int i=nums.length-4;i>=0;i--){
            if(nums[i+1]<=suffixMin[i+1][0]){
                suffixMin[i][0]=nums[i+1];
                suffixMin[i][1]=suffixMin[i+1][0];
            }else if(nums[i+1]<=suffixMin[i+1][1]){
                suffixMin[i][0]=suffixMin[i+1][0];
                suffixMin[i][1]=nums[i+1];
            }else{
                suffixMin[i][0]=suffixMin[i+1][0];
                suffixMin[i][1]=suffixMin[i+1][1];
            }
        }
        return nums[0]+suffixMin[0][0]+suffixMin[0][1];
    }
}