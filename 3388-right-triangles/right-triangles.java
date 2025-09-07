class Solution {
    
    public long numberOfRightTriangles(int[][] grid) {
        long[] rows=new long[grid.length];
        long[] cols=new long[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                rows[i]+=grid[i][j]==1?1:0;
                cols[j]+=grid[i][j]==1?1:0;
            }
        }
        long ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans+=(rows[i]-1)*(cols[j]-1);
                }
            }
        }
        return ans;
    }
}