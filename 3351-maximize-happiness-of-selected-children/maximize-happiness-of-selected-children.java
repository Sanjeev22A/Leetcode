class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n=happiness.length;
        long sum=0L;
        int decre=0;
        for(int i=n-1;i>=n-k;i--){
            sum+=(long)Math.max(happiness[i]-decre,0);
            decre++;
        }
        return sum;
    }
}