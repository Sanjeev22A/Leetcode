class Solution {
    int[] values;
    int[][] dp;
    public int minScoreTriangulation(int[] values) {
        this.values=values;
        dp=new int[values.length][values.length];
        for(int i=0;i<values.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return calculate(0,values.length-1);
    }
    int calculate(int i,int j){
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        if(i+2>j){
            return 0;
        }
        if(i+2==j){
            dp[i][j]=values[i]*values[i+1]*values[i+2];
            return dp[i][j];
        }
        int minScore=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int curScore=values[i]*values[k]*values[j]+calculate(i,k)+calculate(k,j);
            minScore=Math.min(curScore,minScore);
        }
        dp[i][j]=minScore;
        return minScore;
    }
}