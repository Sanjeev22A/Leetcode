class Point{
    int val,index,dir;
    Point(int val,int index,int dir){
        this.val=val;
        this.index=index;
        this.dir=dir;
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        boolean[] visited=new boolean[costs.length];
        PriorityQueue<Point> left=new PriorityQueue<>((a,b)->{
            if(a.val!=b.val){
                return a.val-b.val;
            }else{
                return a.index-b.index;
            }
        });
        PriorityQueue<Point> right=new PriorityQueue<>((a,b)->{
            if(a.val!=b.val){
                return a.val-b.val;
            }else{
                return a.index-b.index;
            }
        });
        int l=0;
        for(int i=0;i<candidates;i++){
            visited[i]=true;
            left.offer(new Point(costs[i],i,1));
            l++;
        }
        int r=costs.length-1;
        for(int i=costs.length-1;i>=costs.length-candidates;i--){
            if(!visited[i]){
                visited[i]=true;
                right.offer(new Point(costs[i],i,-1));
                r--;
            }
            
        }
        long cost=0L;
        
        for(int i=0;i<k;i++){
            if(left.isEmpty()){
                Point cur=right.poll();
                cost+=(long)cur.val;
                
                if(r>=0 && !visited[r]){
                    visited[r]=true;
                    right.offer(new Point(costs[r],r,-1));
                    r--;
                }
            }else if(right.isEmpty()){
                Point cur=left.poll();
                cost+=(long)cur.val;
                
                if(l<costs.length && !visited[l]){
                    visited[l]=true;
                    left.offer(new Point(costs[l],l,1));
                    l++;
                }
            }
            else if(left.peek().val<=right.peek().val){
                Point cur=left.poll();
                cost+=(long)cur.val;
                
                if(l<costs.length && !visited[l]){
                    visited[l]=true;
                    left.offer(new Point(costs[l],l,1));
                    l++;
                }
            }else if(left.peek().val>right.peek().val){
                Point cur=right.poll();
                cost+=(long)cur.val;
                
                if(r>=0 && !visited[r]){
                    visited[r]=true;
                    right.offer(new Point(costs[r],r,-1));
                    r--;
                }
            }
        }
        return cost;

    }
}