class Solution {
    Map<Integer,Integer> dp;
    int count(int amount,int[] coins){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp.containsKey(amount)){
            return dp.get(amount);
        }
        int minCount=Integer.MAX_VALUE;
        for(int i=coins.length-1;i>=0;i--){
            if(coins[i]<=amount){
                int val=count(amount-coins[i],coins);
                if(val!=Integer.MAX_VALUE){
                    minCount=Math.min(val+1,minCount);
                    
                }
            }
        }
        dp.put(amount,minCount);
        return minCount;
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dp=new HashMap<>();
        int val=count(amount,coins);
        return val==Integer.MAX_VALUE?-1:val;
    }
}