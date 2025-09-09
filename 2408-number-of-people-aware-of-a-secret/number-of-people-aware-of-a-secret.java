class Solution {
    
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod=(int)Math.pow(10,9)+7;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=i+delay;j<Math.min(n,i+forget);j++){
                dp[j]=(dp[j]+dp[i])%mod;;
            }
           
        }
        int ans=0;
        for(int i=n-1;i>=n-forget;i--){
            ans=(ans+dp[i])%mod;
        }
        return ans;

    }
}