class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] s0=new int[n]; //Reset
        int[] s1=new int[n]; //Buy
        int[] s2=new int[n]; //Sell
        s0[0]=0; //Nothing to reset
        s1[0]=-prices[0];
        s2[0]=0; //Cant sell nothing
        int ans=0;
        for(int i=1;i<n;i++){
            s0[i]=Math.max(s0[i-1],s2[i-1]);
            s1[i]=Math.max(s1[i-1],s0[i-1]-prices[i]);
            s2[i]=s1[i-1]+prices[i];
            ans=Math.max(Math.max(Math.max(s0[i],s1[i]),s2[i]),ans);
        }
        return ans;
    }
}