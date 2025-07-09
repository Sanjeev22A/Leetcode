class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
        if(k>=n){
            int totalDur=0;
            for(int i=0;i<n;i++){
                totalDur+=(endTime[i]-startTime[i]);
            }
            return eventTime-totalDur;
        }
        //Now we create a sliding window - where we start from ith event to i+k th event consider the free time on either side and now calc the max free time available
        int prevStart=0;
        int[] prefix=new int[n+2];
        prefix[0]=0;
        for(int i=0;i<n;i++){
            int start=startTime[i];
            int curFreeTime=start-prevStart+prefix[i];
            prefix[i+1]=curFreeTime;
            prevStart=endTime[i];
        }
        int endFreeTime=eventTime-endTime[n-1];
        prefix[n+1]=endFreeTime+prefix[n];
        int max=0;
        for(int i=k+1;i<n+2;i++){
            int cur=prefix[i]-prefix[i-k-1];
            max=Math.max(cur,max);
        }
        return max;


        

    }
}