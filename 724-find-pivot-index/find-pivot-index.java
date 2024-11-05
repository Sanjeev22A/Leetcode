class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum=new int[nums.length];
        int[] rightSum=new int[nums.length];
        leftSum[0]=0;
        rightSum[nums.length-1]=0;
        for(int i=0;i<nums.length-1;i++){
            leftSum[i+1]=leftSum[i]+nums[i];
            
        }
        for(int j=nums.length-2;j>=0;j--){
            rightSum[j]=rightSum[j+1]+nums[j+1];
        }
        for(int i=0;i<nums.length;i++){
            if(leftSum[i]==rightSum[i]){
                return i;
            }
        }
        return -1;
    }
}