class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[i].length-2;j++){
                if(isAMagicSquare(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isAMagicSquare(int[][] grid,int rStart,int cStart){
        boolean[] key=new boolean[10];
        for(int i=rStart;i<rStart+3;i++){
            for(int j=cStart;j<cStart+3;j++){
                if(grid[i][j]>0 && grid[i][j]<=9){
                    if(key[grid[i][j]]){
                        return false;
                    }
                    key[grid[i][j]]=true;
                }
                else{
                    return false;
                }
                
                
            }
        }
        int i=rStart,j=cStart;
        int sum=15;
        for(i=0;i<3;i++){
            int rowsum=0;
            int colsum=0;
            for(j=0;j<3;j++){
                rowsum+=grid[rStart+i][cStart+j];
                colsum+=grid[rStart+j][cStart+i];
            }
            if(rowsum!=sum || colsum!=sum){
                return false;
            }
        }
        int diagonalsum=grid[rStart][cStart]+grid[rStart+1][cStart+1]+grid[rStart+2][cStart+2];
        if(diagonalsum!=sum){
            return false;
        }
        diagonalsum=grid[rStart+2][cStart]+grid[rStart+1][cStart+1]+grid[rStart][cStart+2];
    if(diagonalsum!=sum){
            return false;
        }
    return true;

    }
}