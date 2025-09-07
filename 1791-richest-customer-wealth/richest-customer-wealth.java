class Solution {
    long sum(int[] arr){
        long sum=0L;
        for(int a:arr){
            sum+=(long)a;
        }
        return sum;
    }
    public int maximumWealth(int[][] accounts) {
        int cust=0;
        long val=0L;
        for(int i=0;i<accounts.length;i++){
            long sum=sum(accounts[i]);
            if(sum>val){
                val=sum;
                cust=i+1;
            }
        }
        return (int)val;
    }
}