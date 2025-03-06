class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n=(long)Math.pow(grid.length,2);
        long perfectSum=n*(n+1)/2;
        long perfectSquareSum=n*(n+1)*(2*n+1)/6;
        long sum=0,perfectsquaresum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                sum+=grid[i][j];
                perfectsquaresum+=(long)Math.pow(grid[i][j],2);
            }
        }
        int sub=(int)(perfectSum-sum);
        int add=(int)(perfectSquareSum-perfectsquaresum)/sub;
        int x=(add+sub)/2;
        int y=add-x;
        return new int[]{y,x};
    }
}