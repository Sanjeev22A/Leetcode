class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long total=0;
        int counter=0;
        for(int i=happiness.length-1;i>=happiness.length-k;i--){
            total+=Math.max((long)happiness[i]-(long)counter,0L);
            counter++;
            
        }
        return total;
    }
}