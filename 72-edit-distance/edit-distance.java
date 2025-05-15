class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                if(word2.charAt(i-1)==word1.charAt(j-1)){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+1);
                    
                }
                
            }
        }
        return dp[m][n];
    }
}