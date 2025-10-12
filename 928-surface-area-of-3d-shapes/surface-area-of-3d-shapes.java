class Solution {
    public int surfaceArea(int[][] grid) {
        int surfaceArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                    surfaceArea+=2;
                    if(i>0){
                        if(grid[i][j]>grid[i-1][j]){
                            surfaceArea+=grid[i][j]-grid[i-1][j];
                        }
                    }else{
                        surfaceArea+=grid[i][j];
                    }
                    if(i+1<grid.length){
                        surfaceArea+=Math.max(0,grid[i][j]-grid[i+1][j]);
                    }else{
                        surfaceArea+=grid[i][j];
                    }
                    if(j>0){
                        surfaceArea+=Math.max(0,grid[i][j]-grid[i][j-1]);
                    }else{
                        surfaceArea+=grid[i][j];
                    }
                    if(j+1<grid.length){
                        surfaceArea+=Math.max(0,grid[i][j]-grid[i][j+1]);
                    }else{
                        surfaceArea+=grid[i][j];
                    }
                }
            }
        }
        return surfaceArea;
    }
}