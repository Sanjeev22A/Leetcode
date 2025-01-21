class Solution {
    public long gridGame(int[][] grid) {
        long firstRowSum=0;
        for(int i=0;i<grid[0].length;i++){
            firstRowSum+=grid[0][i];
        }
        long secondRowSum=0;
        long minSum=Long.MAX_VALUE;

        for(int turnIndex=0;turnIndex<grid[0].length;turnIndex++){
            firstRowSum-=grid[0][turnIndex];
            minSum=Math.min(minSum,Math.max(firstRowSum,secondRowSum));
            secondRowSum+=grid[1][turnIndex];

        }
        return minSum;
        
    }
}