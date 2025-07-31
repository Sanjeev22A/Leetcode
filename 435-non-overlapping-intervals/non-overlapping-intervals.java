class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }else{
                return Math.abs(a[0]-a[1])-Math.abs(b[0]-b[1]);
            }
            
        });

        int count=0;
        int prev=Integer.MIN_VALUE;
        for(int[] a:intervals){
            if(a[0]<prev){
                count++;
            }else{
                prev=a[1];
            }
        }
        return count;
    }
}