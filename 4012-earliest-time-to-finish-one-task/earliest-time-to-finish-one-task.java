class Solution {
    public int earliestTime(int[][] tasks) {
        int earliestTime=Integer.MAX_VALUE;
        for(int[] a:tasks){
            int val=a[0]+a[1];
            earliestTime=Math.min(earliestTime,val);
        }
        return earliestTime;
    }
}