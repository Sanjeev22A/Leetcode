class Solution {
    int INF=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    continue;
                }
                int top=i>0?dp[i-1][j]:INF;
                int left=j>0?dp[i][j-1]:INF;
                dp[i][j]=Math.min(top,left)+grid[i][j];
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}