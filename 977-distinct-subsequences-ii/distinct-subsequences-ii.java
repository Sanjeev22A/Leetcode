class Solution {
    int MOD=(int)Math.pow(10,9)+7;
    public int distinctSubseqII(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        Map<Character,Integer> lastSeen=new HashMap<>();
        for(int i=1;i<=n;i++){
            dp[i]=(int)(((long)dp[i-1]+(long)dp[i-1])%MOD);
            char c=s.charAt(i-1);
            if(lastSeen.containsKey(c)){
                int idx=lastSeen.get(c);
                dp[i]=(int)(((long)dp[i]-dp[idx-1])%MOD);
                
            }
            if(dp[i]<0){
                    dp[i]+=MOD;
                    dp[i]%=MOD;
            }
            lastSeen.put(s.charAt(i-1),i);
            
        }

        if(dp[n]-1<0){
            return (dp[n]-1+MOD)%MOD;
        }
        return dp[n]-1;
    }
}