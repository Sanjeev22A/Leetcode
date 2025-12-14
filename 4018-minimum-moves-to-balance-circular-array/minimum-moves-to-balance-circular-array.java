class Point{
    int val;
    int dist;
    Point(int val,int dist){
        this.val=val;
        this.dist=dist;
    }
}
class Solution {
    public long minMoves(int[] balance) {
        long ans=0;
        long sum=0;
        int count=0;
        int negIndex=-1;
        int idx=0;
        for(int a:balance){
            sum+=(long)a;
            if(a<0){
                count++;
                negIndex=idx;
            }
            idx++;
        }
        if(sum<0){
            return -1;
        }
        if(count==0){
            return 0;
        }
        PriorityQueue<Point> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a.dist,b.dist);
        });
        for(int i=0;i<balance.length;i++){
            if(balance[i]>0){
                int val=balance[i];
                int roundDist=Math.abs(balance.length-1-i)+negIndex+1;
                int roundDist2=Math.abs(balance.length-1-negIndex)+i+1;
                roundDist=Math.min(roundDist,roundDist2);
                int dist=Math.min(Math.abs(i-negIndex),roundDist);
                Point p=new Point(val,dist);
                //System.out.println(dist);
                pq.offer(p);
            }
        }
        while(balance[negIndex]<0){
            Point p=pq.poll();
            long cost=(long)Math.min(-balance[negIndex],p.val)*(long)p.dist;
            balance[negIndex]+=Math.min(-balance[negIndex],p.val);
            ans+=cost;
        }
        
        
        return ans;
    }
}