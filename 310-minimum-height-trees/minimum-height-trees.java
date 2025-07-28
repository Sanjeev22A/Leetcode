class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1 && edges.length==0){
            List<Integer> temp=new ArrayList<>();
            temp.add(0);
            return temp;
        }
        int[] degree=new int[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] a:edges){
            degree[a[0]]++;
            degree[a[1]]++;
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        List<Integer> result=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        while(!q.isEmpty()){
            int size=q.size();
            result=new ArrayList(q);
            for(int i=0;i<size;i++){
                int cur=q.poll();
                visited.add(cur);
                for(int a:graph.get(cur)){
                    if(visited.contains(a)){
                        continue;
                    }
                    degree[a]--;
                    
                    if(degree[a]==1){
                        q.offer(a);
                    }
                }
            }
        }
        return result;

    }
}