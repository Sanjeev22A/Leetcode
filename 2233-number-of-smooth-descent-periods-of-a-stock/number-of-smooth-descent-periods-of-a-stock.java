class Solution {
    public long getDescentPeriods(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[] dp=new int[prices.length];
        Arrays.fill(dp,1);
        long ans=1;
        for(int i=1;i<prices.length;i++){
            if(prices[i]+1==prices[i-1]){
                dp[i]=dp[i-1]+1;
            }
         
            ans+=(long)dp[i];
        }
        return ans;

    }
}