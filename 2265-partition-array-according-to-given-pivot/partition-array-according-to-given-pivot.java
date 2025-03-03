class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result=new int[nums.length];
        int less=0,greater=nums.length-1;
        for(int i=0,j=nums.length-1;i<nums.length;i++,j--){
            if(nums[i]<pivot){
                result[less++]=nums[i];
            }
            if(nums[j]>pivot){
                result[greater--]=nums[j];
            }
        }
        while(less<=greater){
            result[less++]=pivot;
        }
        return result;
    }
}