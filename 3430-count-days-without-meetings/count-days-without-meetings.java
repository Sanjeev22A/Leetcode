class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];

            }
            return b[1]-a[1];
        });
        int available=days;
        int prevStart=0;
        int prevEnd=0;
        for(int[] a:meetings){
            if(a[1]+1>prevEnd){
                available-=(a[1]+1-Math.max(prevEnd,a[0]));
                prevEnd=a[1]+1;
                prevStart=a[0];
            }
        }
        return available;
    }
}