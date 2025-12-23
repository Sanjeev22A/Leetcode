class Solution {
    public int maxTwoEvents(int[][] events) {
        for(int[] a:events){
            a[1]++;
        }
        Arrays.sort(events,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            else if(a[1]!=b[1]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[2],b[2]);
        });
        int last=Integer.MAX_VALUE;
        TreeMap<Integer,Integer> val=new TreeMap<>();
        val.put(last,0);
        int ans=0;
        

        for(int i=events.length-1;i>=0;i--){
            
            int curMax=val.ceilingEntry(events[i][1]).getValue();
            ans=Math.max(events[i][2]+curMax,ans);
            int key=val.ceilingEntry(events[i][1]).getKey();
            //System.out.println(events[i][2]+":"+key);
            curMax=val.ceilingEntry(events[i][0]).getValue();
          
            val.put(events[i][0],Math.max(curMax,events[i][2]));
        }
        
        return ans;
    }
}