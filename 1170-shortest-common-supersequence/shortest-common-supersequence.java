class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        int row=str1.length()+1;
        int col=str2.length()+1;
        for(int i=0;i<row;i++){
            //at 0th column length of str2=0 and hence output=length(str1)
            dp[i][0]=i;
        }
        for(int j=0;j<col;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    //Not longest subsequence but here we calculate the shortest supersequence
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+1;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        int i=row-1,j=col-1;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                result.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]<dp[i][j-1]){
                result.append(str1.charAt(i-1));
                i--;
            }else{
                result.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            result.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            result.append(str2.charAt(j-1));
            j--;
        }
        return result.reverse().toString();

    }
}