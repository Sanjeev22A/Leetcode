class Solution {
    int count=0;
    void dfs(boolean[][] gridHolder,char[][] grid,int i,int j){
        
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0){
            return;
        }
        if(gridHolder[i][j]==true){return;}
        if(grid[i][j]=='1'){
            gridHolder[i][j]=true;
            dfs(gridHolder,grid,i+1,j);
             dfs(gridHolder,grid,i,j+1);
              dfs(gridHolder,grid,i-1,j);
               dfs(gridHolder,grid,i,j-1);
        }
        
    }
    public int numIslands(char[][] grid) {
        boolean[][] gridHolder=new boolean[grid.length][grid[0].length];
        for(int i=0;i<gridHolder.length;i++){
            for(int j=0;j<gridHolder[i].length;j++){
                if(!gridHolder[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(gridHolder,grid,i,j);
                }
            }
        }
        return count;
    }
}