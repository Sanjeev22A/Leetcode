class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->(Integer.compare(a[1],b[1])));
        int count=0;
        long endInterval=Long.MIN_VALUE;
        //System.out.println(endInterval>=(long)points[0][0]);
        for(int[] a:points){
            if(endInterval>=(long)a[0]){
                continue;
            }
            endInterval=(long)a[1];
            //System.out.println(a[1]+":"+endInterval);
            count++;
        }
        return count;
    }
}