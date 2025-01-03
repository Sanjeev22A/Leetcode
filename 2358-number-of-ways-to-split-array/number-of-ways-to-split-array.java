class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum=new long[nums.length];
        long[] suffixSum=new long[nums.length];
        
        long sum=0;
      
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==0){
                prefixSum[i]=nums[i];
                
            }
            else{
                prefixSum[i]=prefixSum[i-1]+nums[i];
                
            }
        }
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(prefixSum[i]>=sum-prefixSum[i]){
                count++;
            }
        }
        return count;
        
    }
}