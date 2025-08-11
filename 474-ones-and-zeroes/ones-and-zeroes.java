class Solution {
    int[] countZerosOnes(String s){
        int[] ans=new int[2];
        for(char c:s.toCharArray()){
            if(c=='0'){
                ans[0]++;
            }else{
                ans[1]++;
            }
        }
        return ans;
    }
    int largestSubSet=0;
    int m,n;
    String[] strs;
    int[][][] dp;
    int dp(int index,int[] curCount){
        if(index>=strs.length){
            return 0;
        }
        if(dp[index][curCount[0]][curCount[1]]!=-1){
            return dp[index][curCount[0]][curCount[1]];
        }
        int[] arr=countZerosOnes(strs[index]);
        int val=0;
        if(curCount[0]+arr[0]<=m && curCount[1]+arr[1]<=n){
            
            
            val=1+dp(index+1,new int[]{curCount[0]+arr[0],curCount[1]+arr[1]});
        }
        
        val=Math.max(val,dp(index+1,curCount));
        dp[index][curCount[0]][curCount[1]]=val;
        return val;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        this.m=m;
        this.n=n;
        this.strs=strs;
        return dp(0,new int[]{0,0});
        
    }
}