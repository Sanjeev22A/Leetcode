class Solution {
    int count(int n,int k){
        int ans=n-1;
        n--;
        for(int i=1;i<k;i++){
            ans*=(n);
            n--;

        }
        return ans;
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=10;
        for(int i=2;i<=n;i++){
            dp[i]+=(dp[i-1]+count(10,i));
            //System.out.println(count(10,i));
        }
        return dp[n];
    }
}