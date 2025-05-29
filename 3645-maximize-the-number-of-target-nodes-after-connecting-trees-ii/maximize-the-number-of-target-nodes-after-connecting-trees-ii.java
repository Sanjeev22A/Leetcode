class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int m=edges1.length+1;
        int n=edges2.length+1;
        int[] n1=new int[m];
        int[] n2=new int[n];
        int[] c1=new int[2];
        int[] c2=new int[2];
        List<List<Integer>> adj1=new ArrayList<>();
        List<List<Integer>> adj2=new ArrayList<>();
        for(int i=0;i<m;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            adj2.add(new ArrayList<>());
        }
        for(int[] a:edges1){
            adj1.get(a[0]).add(a[1]);
            adj1.get(a[1]).add(a[0]);
        }
        for(int[] a:edges2){
            adj2.get(a[0]).add(a[1]);
            adj2.get(a[1]).add(a[0]);
        }
        bfs(0,adj1,c1,n1);
        bfs(0,adj2,c2,n2);
        int[] res=new int[m];
        int max=Math.max(c2[0],c2[1]);
        for(int i=0;i<m;i++){
            res[i]=c1[n1[i]]+max;
        }
        return res;

    }

    void bfs(int root,List<List<Integer>> adj,int[] c,int[] n){
        int m=adj.size();
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[m];
        q.add(root);
        n[root]=0;
        c[n[root]]++;
        while(!q.isEmpty()){
            int node=q.poll();
            visited[node]=true;
            for(int neigh:adj.get(node)){
                if(!visited[neigh]){
                    n[neigh]=1-n[node];
                    c[n[neigh]]++;
                    visited[neigh]=true;
                    q.offer(neigh);
                }
            }
        }
    }
}