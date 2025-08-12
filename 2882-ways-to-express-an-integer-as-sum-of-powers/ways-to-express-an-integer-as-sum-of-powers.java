class Solution {
    int MOD=(int)Math.pow(10,9)+7;
    long power(long n,int x){
        long res=1;
        while(x>0){
            if(x%2==1){
                res=(res*n);
                x--;
            }
            n=(n*n);
            x>>=1;
        }
        return res;
    }
    int[][] dp;

    int dp(int n,int x,int curIndex){
        if(n==0){
            return 1;
        }
        if(n==1 && curIndex==1){
            return 1;
        }
        if(dp[n][curIndex]!=-1){
            return dp[n][curIndex];
        }
        int val=0;
        for(int i=curIndex;i<=n;i++){
            long power=power((long)i,x);
            if(power>n){
                break;
            }
            val=(val+dp(n-(int)power,x,i+1))%MOD;
        }
        dp[n][curIndex]=val;
        return val;
    }
    public int numberOfWays(int n, int x) {
        dp=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return dp(n,x,1);
    }
}