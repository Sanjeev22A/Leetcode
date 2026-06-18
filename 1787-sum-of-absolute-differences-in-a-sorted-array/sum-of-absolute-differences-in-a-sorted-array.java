class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        long totalSum=0L;
        long[] prefixSum=new long[nums.length];
        totalSum+=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+(long)nums[i-1];
            totalSum+=nums[i];
        }
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            long beforeSum=(long)i*(long)nums[i]-prefixSum[i];
            long afterSumInit=totalSum-prefixSum[i]-(long)nums[i];
            int count=nums.length-i-1;
            long afterSum=afterSumInit-(long)count*(long)nums[i];
            //System.out.println(beforeSum+":"+afterSumInit+":"+prefixSum[i]+":"+afterSum+":"+totalSum);
            res[i]=(int)beforeSum+(int)afterSum;
        }
        return res;
    }
}