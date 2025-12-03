class Solution {
    int[][][] dp;
    int MOD=(int)Math.pow(10,9)+7;
    int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    boolean inMemory(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    int recurse(int i,int j,int maxMoves,int m,int n){
        if(maxMoves<0){
            return 0;
        }
        if(inMemory(i,j,m,n) && dp[i][j][maxMoves]!=-1){
            return dp[i][j][maxMoves];
        }
        if(!inMemory(i,j,m,n)){
            if(maxMoves>=0){
                return 1;
            }else{
                return 0;
            }
        }
        if(maxMoves<0){
            return 0;
        }
        int total=0;
        for(int[] a:dir){
            int nx=i+a[0],ny=j+a[1];
            int cur=recurse(nx,ny,maxMoves-1,m,n);
            total=(int)(((long)total+cur)%MOD);
        }
        dp[i][j][maxMoves]=total;
        return total;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return recurse(startRow,startColumn,maxMove,m,n);
    }
}