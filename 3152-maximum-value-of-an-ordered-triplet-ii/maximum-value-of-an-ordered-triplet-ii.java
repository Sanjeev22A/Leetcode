class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] prefix_max=new int[nums.length];
        int[] suffix_max=new int[nums.length];
        int i=0,j=nums.length-1;
        while(i<nums.length){
            if(i==0){
                prefix_max[i]=nums[i];
                suffix_max[j]=nums[j];
            }
            else{
                prefix_max[i]=Math.max(nums[i],prefix_max[i-1]);
                suffix_max[j]=Math.max(nums[j],suffix_max[j+1]);

            }
            i++;j--;
        }
        long maxValue=0;
        i=1;
        while(i<nums.length-1){
            long curr=(long)(prefix_max[i-1]-nums[i])*suffix_max[i+1];
            
            maxValue=Math.max(curr,maxValue);
            i++;
        }
        return maxValue;
    }
}