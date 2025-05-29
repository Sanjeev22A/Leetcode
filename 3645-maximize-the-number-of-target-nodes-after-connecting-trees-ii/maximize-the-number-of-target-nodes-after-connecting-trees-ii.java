class Solution {
    Integer INF=100000+1;
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int m=edges1.length+1;
        int n=edges2.length+1;
        int[] c1=new int[2];
        int[] c2=new int[2];
        int[] n1=new int[m];
        int[] n2=new int[n];
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
        
        
        bfs(0,m,adj1,c1,n1);
             
        bfs(0,n,adj2,c2,n2);
            
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            res[i]=c1[n1[i]]+Math.max(c2[0],c2[1]);
        }
        return res;


    }

    void bfs(int root,int m,List<List<Integer>> adj,int[] color,int[] n){
       boolean[] visited=new boolean[m];
       Queue<Integer> q=new LinkedList<>();
       n[root]=0;
       color[0]++;
       q.offer(root);
       while(!q.isEmpty()){
            int node=q.poll();
            visited[node]=true;
            for(int neigh:adj.get(node)){
                if(!visited[neigh]){
                    n[neigh]=1-n[node];
                    color[n[neigh]]++;
                    visited[neigh]=true;
                    q.offer(neigh);
                }
            }
       }
        
        
    }


}