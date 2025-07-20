
class Solution {
    int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    int[][] grid;
    boolean[][] visited;
    boolean isMemorySafe(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    long dfs(int i,int j){
        if(!isMemorySafe(i,j,grid.length,grid[0].length)){
            return 0L;
        }
        if(visited[i][j]){
            return 0L;
        }
        visited[i][j]=true;
        long ans=0L;
        for(int[] a:dir){
            ans+=dfs(i+a[0],j+a[1]);
        }
        ans+=grid[i][j];
        return ans;
    }
    public int countIslands(int[][] grid, int k) {
        this.grid=grid;
        this.visited=new boolean[this.grid.length][this.grid[0].length];
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                if(grid[i][j]==0){
                    visited[i][j]=true;
                }
            }
        }
        int count=0;
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){
                if(!visited[i][j]){
                    long sum=dfs(i,j);
                    if(sum%(long)k==0l){
                        count++;
                    }
                }
                
            }
        }
        return count;
    }   
}