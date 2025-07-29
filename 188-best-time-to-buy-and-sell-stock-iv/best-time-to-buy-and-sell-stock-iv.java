class Solution {
    int booleanToInteger(boolean key){
        if(key){
            return 1;
        }
        return 0;
    }
    int k;
    int[][][] dp; //dp by curDay,buyCount and isActiveBy
    int dp(int[] prices,int curDay,int buyCount,boolean isActiveBuy){
        if(curDay>=prices.length){
            return 0;
        }
        int key=booleanToInteger(isActiveBuy);
        if(dp[curDay][buyCount][key]!=-1){
            return dp[curDay][buyCount][key];
        }
        int ans=Integer.MIN_VALUE;
        if(isActiveBuy){
            int v1=prices[curDay]+dp(prices,curDay+1,buyCount,false);
            int v2=dp(prices,curDay+1,buyCount,true);
    
            ans=Math.max(ans,Math.max(v1,v2));
        }else if(!isActiveBuy && buyCount<k){
            int v1=-prices[curDay]+dp(prices,curDay+1,buyCount+1,true);
            int v2=dp(prices,curDay+1,buyCount,false);
            
            ans=Math.max(ans,Math.max(v1,v2));
        }else{
            return 0;
        }
        dp[curDay][buyCount][key]=ans;
        return ans;
    }
    public int maxProfit(int k, int[] prices) {
        this.k=k;
        dp=new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return dp(prices,0,0,false);
    }
}