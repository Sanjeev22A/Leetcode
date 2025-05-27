class Solution {
    int INF=Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],INF);
        }
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            int m=triangle.get(i).size();
            for(int j=0;j<m;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }
            }
        }
        
        int am=INF;
        for(int i=0;i<n;i++){
            am=Math.min(am,dp[n-1][i]);
        }
        return am;
    }
}