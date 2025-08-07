class UnionFind{
    int[] parent;
    UnionFind(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(x==parent[x]){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    
    void union(int x,int y){
        int parentx=find(x);
        int parenty=find(y);
        if(parentx!=parenty){
            parent[parenty]=parentx;
        }
        return;
    }
    boolean isConnected(int x,int y){
        int parentx=find(x);
        int parenty=find(y);
        return parentx==parenty;
    }

}
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] queriesModified=new int[queries.length][4];
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<3;j++){
                queriesModified[i][j]=queries[i][j];
            }
            queriesModified[i][3]=i;
        }
        Arrays.sort(queriesModified,(a,b)->(a[2]-b[2]));
        Arrays.sort(edgeList,(a,b)->(a[2]-b[2]));
        boolean[] ans=new boolean[queries.length];
        int j=0;
        UnionFind uf=new UnionFind(n);
        for(int i=0;i<queriesModified.length;i++){
            while(j<edgeList.length && edgeList[j][2]<queriesModified[i][2]){
                uf.union(edgeList[j][0],edgeList[j][1]);
                j++;
            }
            if(uf.isConnected(queriesModified[i][0],queriesModified[i][1])){
                ans[queriesModified[i][3]]=true;
            }
        }
        return ans;
    }
}