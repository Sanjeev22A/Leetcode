class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j]=matrix[i][j]-'0';
                }else if(matrix[i][j]=='1'){
                    int top=dp[i-1][j];
                    int left=j>0?dp[i][j-1]:0;
                    int diag=j>0?dp[i-1][j-1]:0;
                    dp[i][j]=Math.min(top,Math.min(left,diag))+1;
                }
                System.out.println(dp[i][j]);
                max=Math.max(dp[i][j],max);
            }
        }
        return max*max;
    }
}