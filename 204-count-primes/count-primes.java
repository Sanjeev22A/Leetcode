class Solution {
    public int countPrimes(int n) {
        
        if(n==0 || n==1){
            return 0;
        }
        n=n-1;
        boolean[] dp=new boolean[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=true;
        }
        dp[0]=false;
        dp[1]=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(dp[i]==true){
                for(int j=i*i;j<=n;j+=i){
                    dp[j]=false;
                }
            }


        }
        int count=0;
        for(boolean a:dp){
            if(a){
                count++;
            }
        }
        return count;
    }
}