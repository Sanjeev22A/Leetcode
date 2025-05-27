class Solution {
    int INF=Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        int min2=INF;
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
            min2=Math.min(min2,dp[0][i]);
        }
        if(n==1){
            return min2;
        }
        int min=INF;
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int left=j>0?dp[i-1][j-1]:INF;
                int top=dp[i-1][j];
                int right=j<n-1?dp[i-1][j+1]:INF;
                dp[i][j]=Math.min(left,Math.min(top,right))+matrix[i][j];
                if(i==n-1){
                    min=Math.min(dp[i][j],min);
                }
            }
        }
        return min;
    }
}