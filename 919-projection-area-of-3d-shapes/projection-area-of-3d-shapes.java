class Solution {
    public int projectionArea(int[][] grid) {
        int ans=0;
        for(int[] a:grid){
            int rowMax=0;
            for(int b:a){
                if(b!=0){
                    ans++;
                }
                rowMax=Math.max(b,rowMax);
            }
            ans+=rowMax;
        }

        for(int j=0;j<grid[0].length;j++){
            int colMax=0;
            for(int i=0;i<grid.length;i++){
                colMax=Math.max(grid[i][j],colMax);
            }
            ans+=colMax;
        }
        return ans;
    }
}