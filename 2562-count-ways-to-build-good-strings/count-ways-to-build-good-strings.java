class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
         int MOD = 1_000_000_007;
        int[] dp=new int[high+1];
        dp[0]=1;
        for(int i=1;i<=high;i++){
            long val1=0,val2=0;
            if(i-zero>=0){
                val1=(dp[i]+dp[i-zero]);
            }
            if(i-one>=0){
                val2=(dp[i]+dp[i-one]);
            }
            dp[i]=(int)(val1+val2)%MOD;
        }
        int count=0;
        for(int i=low;i<=high;i++){
            count=(count+dp[i])%MOD;
        }
        return count;
    }
}