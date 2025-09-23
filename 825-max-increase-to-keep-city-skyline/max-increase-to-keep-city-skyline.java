class Solution {
    int max(int[] row){
        int max=0;
        for(int a:row){
            max=Math.max(a,max);
        }
        return max;
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax=new int[grid.length];
        int[] colMax=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            rowMax[i]=max(grid[i]);
        }
        for(int i=0;i<grid[0].length;i++){
            int m=0;
            for(int j=0;j<grid.length;j++){
                m=Math.max(grid[j][i],m);
            }
            colMax[i]=m;
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                ans+=(Math.min(rowMax[i],colMax[j])-grid[i][j]);
            }
        }
        return ans;
    }
}