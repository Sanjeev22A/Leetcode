class Solution {
    boolean isValid(int i,int j,int row,int col){
        if(i<0 || i>=row || j<0 || j>=col){return false;}
        return true;
    }
    int calculateFish(int[][] grid,int i,int j,boolean[][] visited){
        if(isValid(i,j,grid.length,grid[0].length)){
            if(grid[i][j]==0 || visited[i][j]){
                return 0;
            }
            visited[i][j]=true;
            int maxCount=grid[i][j]+calculateFish(grid,i,j-1,visited)+calculateFish(grid,i,j+1,visited)+calculateFish(grid,i-1,j,visited)+calculateFish(grid,i+1,j,visited);
            return maxCount;
        }
        return 0;
    }
    public int findMaxFish(int[][] grid) {
        int maxCount=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    visited[i][j]=true;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]>0){
                    maxCount=Math.max(maxCount,calculateFish(grid,i,j,visited));
                }
            }
        }
        return maxCount;
    }
}