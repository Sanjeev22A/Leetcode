class Solution {
    class Pair{
        int startProcess,endProcess,gap;
        Pair(int startProcess,int endProcess,int gap){
            this.startProcess=startProcess;
            this.endProcess=endProcess;
            this.gap=gap;
        }
    }
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(b.gap-a.gap));
        int n=startTime.length;
        int prevStart=0;
        for(int i=0;i<n;i++){
            int curStart=startTime[i];
            int curGap=curStart-prevStart;
            Pair p=new Pair(i-1,i,curGap);
            prevStart=endTime[i];
            pq.offer(p);
        }
        int curGap=eventTime-endTime[n-1];
        pq.add(new Pair(n-1,n,curGap));  //If -1 as start process then start window, if n as end process end window
        int max=0;
        int prevEnd=0;
        for(int i=0;i<n;i++){
            int curProcessTime=endTime[i]-startTime[i];
            int nextStart=i==n-1?eventTime:startTime[i+1];
            int gap=nextStart-prevEnd;
            //System.out.println(gap+":"+nextStart+":"+prevEnd);
            prevEnd=endTime[i];

            List<Pair> temp=new ArrayList<>();
            boolean canHold=false;
            while(!pq.isEmpty()){
                Pair cur=pq.poll();
                temp.add(cur);
                if(cur.gap<curProcessTime){
                    break;
                }
                else if(cur.startProcess==i || cur.endProcess==i){
                    continue;
                }else{
                    //System.out.println(i+":"+cur.startProcess+":"+cur.endProcess+":"+cur.gap);
                    canHold=true;
                    break;
                }
            }
            if(canHold){
                max=Math.max(max,gap);
            }else{
                max=Math.max(max,gap-curProcessTime);
            }
            for(Pair p:temp){
                pq.offer(p);
            }
        }
        return max;
    }
}