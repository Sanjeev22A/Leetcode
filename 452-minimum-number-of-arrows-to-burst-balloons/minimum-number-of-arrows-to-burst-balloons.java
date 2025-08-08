class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int count=0;
        long prevEnd=Long.MIN_VALUE;
        for(int[] a:points){
            if((long)a[0]>prevEnd){
                count++;
                prevEnd=(long)a[1];
            }
        }
        return count;
    }
}