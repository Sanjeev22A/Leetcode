class Solution {
    int[][] dp;
    int alternateCount(int[] nums,int i,int parity){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][parity]!=-1){
            return dp[i][parity];
        }
        
        if(nums[i]%2!=parity){
            int val=Math.max(1+alternateCount(nums,i+1,nums[i]%2),alternateCount(nums,i+1,parity));
            dp[i][parity]=val;
        }else{
            int val=alternateCount(nums,i+1,parity);
            dp[i][parity]=val;
        }
        return dp[i][parity];
    }
    public int maximumLength(int[] nums) {
        dp=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int zeroCount=0;
        int oneCount=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]%2;
            if(nums[i]==0){
                zeroCount++;
            }
            if(nums[i]==1){
                oneCount++;
            }
        }
        int alternateLength=Math.max(alternateCount(nums,0,0),alternateCount(nums,0,1));
        return Math.max(alternateLength,Math.max(zeroCount,oneCount));

    }
}