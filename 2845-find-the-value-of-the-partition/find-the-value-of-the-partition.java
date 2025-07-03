class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int minVal=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            minVal=Math.min(minVal,Math.abs(nums[i+1]-nums[i]));
        }
        return minVal;
    }
}