class Solution {
    int INF=Integer.MAX_VALUE;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0]=1;
                    continue;
                }
                int top=0,left=0;
                if(i>0 && obstacleGrid[i-1][j]!=1){
                    top=dp[i-1][j];
                }
                if(j>0 && obstacleGrid[i][j-1]!=1){
                    left=dp[i][j-1];
                }
                dp[i][j]=top+left;
            }
        }
        
        return dp[m-1][n-1];
    }
}