class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum=new long[nums.length];
        long[] suffixSum=new long[nums.length];
        
        long sum=0;
        for(int a:nums){
            sum+=a;
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                prefixSum[i]=nums[i];
                suffixSum[i]=sum-prefixSum[i];
            }
            else{
                prefixSum[i]=prefixSum[i-1]+nums[i];
                suffixSum[i]=sum-prefixSum[i];
            }
        }
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(prefixSum[i]>=suffixSum[i]){
                count++;
            }
        }
        return count;
        
    }
}