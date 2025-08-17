class Solution {
    int compare(int[] p1,int[] p2){
        int d1=p1[0]*p1[0]+p1[1]*p1[1];
        int d2=p2[0]*p2[0]+p2[1]*p2[1];
        return d1-d2;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return compare(a,b);
        });
        for(int[] a:points){
            pq.offer(a);
        }
        int[][] soln=new int[k][2];
        for(int i=0;i<k;i++){
            int[] a=pq.poll();
            soln[i]=a;
        }
        return soln;
    }
}