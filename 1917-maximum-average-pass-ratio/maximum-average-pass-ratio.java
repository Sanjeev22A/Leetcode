class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            double d1=(double)a[0]/a[1];
            double d2=(double)(a[0]+1)/(double)(a[1]+1);
            double d3=(double)b[0]/b[1];
            double d4=(double)(b[0]+1)/(double)(b[1]+1);
            double t1=d2-d1;
            double t2=d4-d3;
            return Double.compare(t2,t1);
        });
        for(int[] a:classes){
            pq.offer(a);
        }
        for(int i=0;i<extraStudents;i++){
            int[] cur=pq.poll();
            cur[0]++;
            cur[1]++;
            pq.offer(cur);

        }
        double avg=0.0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            avg+=((double)cur[0])/cur[1];
        }
        return avg/classes.length;
    }
}