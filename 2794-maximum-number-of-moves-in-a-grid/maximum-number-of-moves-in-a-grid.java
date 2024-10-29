class Solution {
    private int logic(int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=grid[0].length-1;i>=0;i--){
            for(int j=grid.length-1;j>=0;j--){
                if(i==grid[0].length-1){
                    dp[j][i]=0;
                    
                }
                else{
                    int val1=0;
                    boolean flag=false;
                    if(grid[j][i+1]>grid[j][i]){
                        val1=dp[j][i+1];
                        flag=true;
                    }
                    int val2=Integer.MIN_VALUE,val3=Integer.MIN_VALUE;
                    if(j>0 && grid[j-1][i+1]>grid[j][i]){
                        val2=dp[j-1][i+1];
                        flag=true;
                    }
                    if(j<grid.length-1 && grid[j+1][i+1]>grid[j][i]){
                        val3=dp[j+1][i+1];
                        flag=true;
                    }
                    if (flag) {
                        dp[j][i] = 1 + Math.max(val1, Math.max(val2, val3));
                    } else {
                         dp[j][i] = 0;
                    }
                }
            }

        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            if(result<dp[i][0]){
                result=dp[i][0];
            }
        }
        if(result<0){
            return 0;
        }
        return result;
    }
    public int maxMoves(int[][] grid) {
        return logic(grid);
    }
}