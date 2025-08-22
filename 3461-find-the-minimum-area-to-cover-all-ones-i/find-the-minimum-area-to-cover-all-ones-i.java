class Solution {
    int inf=Integer.MAX_VALUE,negInf=Integer.MIN_VALUE;
    public int minimumArea(int[][] grid) {
        int widthLow=inf,widthHigh=negInf,heightLow=inf,heightHigh=negInf;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    widthLow=Math.min(widthLow,j);
                    widthHigh=Math.max(widthHigh,j);
                    heightLow=Math.min(heightLow,i);
                    heightHigh=Math.max(heightHigh,i);
                }
            }
                
        }
        return (heightHigh-heightLow+1)*(widthHigh-widthLow+1);
    }
}