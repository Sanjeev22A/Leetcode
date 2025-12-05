class Solution {
    public int countPartitions(int[] nums) {
        int totalSum=0;
        for(int a:nums){
            totalSum+=a;
        }
        int curSum=0,count=0;
        for(int i=0;i<nums.length-1;i++){
            curSum+=nums[i];
            int rightSum=totalSum-curSum;
            if((curSum-rightSum)%2==0){
                count++;
            }
        }
        return count;
    }
}