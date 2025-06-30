class Solution {
    int count(int n,int k){
        int val=n-1;
        for(int i=0;i<k-1;i++){
            val=val*(--n);
        }
        return val;
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=10;
        for(int i=2;i<=n;i++){
            dp[i]=count(10,i)+dp[i-1];
        }
        return dp[n];
    }
}