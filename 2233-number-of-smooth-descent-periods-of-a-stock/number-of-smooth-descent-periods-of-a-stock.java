class Solution {
    public long getDescentPeriods(int[] prices) {
        if(prices.length==0){
            return 0;
        }

        long cur=1;
        long ans=1;
        for(int i=1;i<prices.length;i++){
            if(prices[i]+1==prices[i-1]){
                cur++;
            }else{
                cur=1;
            }
            
            ans+=cur;
           
        }
        return ans;

    }
}