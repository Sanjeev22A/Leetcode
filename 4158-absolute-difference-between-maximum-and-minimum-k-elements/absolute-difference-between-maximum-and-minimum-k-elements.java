class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int a=0,b=0;
        for(int i=0;i<k;i++){
            a+=nums[i];
            b+=nums[nums.length-i-1];
        }
        return b-a;
    }
}