class Solution {

    public int countSquares(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int ans=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int left=j>0?dp[i][j-1]:0;
                int bottom=i>0?dp[i-1][j]:0;
                int diagonal=i>0 && j>0?dp[i-1][j-1]:0;
                int cur=Math.min(left,Math.min(bottom,diagonal));
                if(matrix[i][j]==0){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=cur+1;
                }
                //System.out.println(dp[i][j]);
                ans+=dp[i][j];
            }
        }
        return ans;
        
    }
}