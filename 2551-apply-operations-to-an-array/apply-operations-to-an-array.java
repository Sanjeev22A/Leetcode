class Solution {
    void operate(int[] nums,int i){
        nums[i]=nums[i]*2;
        if(i+1<nums.length){
            nums[i+1]=0;
        }
    }
    void shiftZeros(int[] nums){
        int lastNonZero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[lastNonZero]=nums[i];
                lastNonZero++;
            }
        }
        for(int i=lastNonZero;i<nums.length;i++){
            nums[i]=0;
        }
    }
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                operate(nums,i);
            }
        }
        shiftZeros(nums);
        return nums;
    }   
}