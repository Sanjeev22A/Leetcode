class Solution {
    int bfs(int i,List<List<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        int cur=i;
        q.offer(i);

        Map<Integer,Integer> distance=new HashMap<>();
        distance.put(cur,0);
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int a=q.poll();
            //System.out.println(a+":"+i);
            for(int j:adj.get(a)){
                if(!distance.containsKey(j)){
                    distance.put(j,distance.get(a)+1);
                    q.offer(j);
                    //System.out.println(j);
                }else if(distance.get(a)<=distance.get(j)){
                    ans=Math.min(ans,distance.get(a)+distance.get(j)+1);
                }
            }
        }
        return ans;
    }
    public int findShortestCycle(int n, int[][] edges) {
        int ans=Integer.MAX_VALUE;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        for(int i=0;i<n;i++){
            int count=bfs(i,adj);
            if(count==Integer.MAX_VALUE){
                continue;
            }
           
            ans=Math.min(count,ans);
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}