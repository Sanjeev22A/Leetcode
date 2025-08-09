class Solution {
    int[][] dp;
    int booleanToInt(boolean key){
        if(key){
            return 1;
        }
        return 0;
    }
    int calculateProfit(int[] prices,int fee,int curIndex,boolean activeBuy){
        if(curIndex>=prices.length){
            return 0;
        }
        int idx=booleanToInt(activeBuy);
        if(dp[curIndex][idx]!=-1){
            return dp[curIndex][idx];
        }
        int ans=Integer.MIN_VALUE;
        if(activeBuy){
            int val1=prices[curIndex]+calculateProfit(prices,fee,curIndex+1,false);
            ans=Math.max(ans,val1);
        }
        else{
            int val2=-prices[curIndex]-fee+calculateProfit(prices,fee,curIndex+1,true);
            ans=Math.max(ans,val2);
        }
        int val3=calculateProfit(prices,fee,curIndex+1,activeBuy);
        ans=Math.max(ans,val3);
        dp[curIndex][idx]=ans;
        return ans;
    }
    public int maxProfit(int[] prices, int fee) {
        dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return calculateProfit(prices,fee,0,false);
    }
}