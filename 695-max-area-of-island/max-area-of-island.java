class Solution {
    int negINF=Integer.MIN_VALUE;
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int area=negINF;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n]; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    area=Math.max(dfs(i,j,m,n,visited,grid),area);
                }
            }
        }
        return area;
    }
    boolean checkIfSafe(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    int dfs(int i,int j,int m,int n,boolean[][] visited,int[][] grid){
        if(!checkIfSafe(i,j,m,n)){
            return 0;
        }
        if(visited[i][j]){
            return 0;
        }
        
        if(grid[i][j]==0){
            return 0;
        }
        int area=1;
        visited[i][j]=true;
        for(int[] a:dir){
            area+=dfs(i+a[0],j+a[1],m,n,visited,grid);
        }
        return area;
    }
}