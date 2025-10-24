class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] leftMax=new int[nums.length];
        leftMax[0]=nums[0];
        int[] rightMin=new int[nums.length];
        rightMin[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],nums[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],nums[i]);
        }
        for(int i=1;i<nums.length;i++){
            if(leftMax[i-1]<=rightMin[i]){
                return i;
            }
        }
        return -1;
    }
}