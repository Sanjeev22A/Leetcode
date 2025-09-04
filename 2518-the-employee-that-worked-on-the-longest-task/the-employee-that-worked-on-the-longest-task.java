class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int time=0,id=-1;
        int prev=0;
        for(int[] a:logs){
            int curTime=a[1]-prev;
            if(curTime>time){
                time=curTime;
                id=a[0];
            }
            if(curTime==time){
                id=Math.min(id,a[0]);
            }
            prev=a[1];
        }
        return id;

    }
}