class Solution {
    boolean isValid(int x,int y,int[][] grid){
        if(x>=0 && x<grid.length  && y>=0 && y<grid[0].length){
            return true;
        }
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        int[][] movement=new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
        int n=grid.length;
        int m=n*n;
        int xStart=0,yStart=0;
        int counter=1;
        if(grid[xStart][yStart]!=0){
            return false;
        }
        while(counter<m){
            //System.out.println(counter);
            boolean isValidSeen=false;
            for(int[] a:movement){
                int xMod=xStart+a[0],yMod=yStart+a[1];
                if(isValid(xMod,yMod,grid) && grid[xMod][yMod]==counter){
                    counter++;
                    xStart=xMod;
                    yStart=yMod;
                    isValidSeen=true;
                    break;
                }
            }
            if(!isValidSeen){
                return false;
            }
        }
        return true;
    }
}