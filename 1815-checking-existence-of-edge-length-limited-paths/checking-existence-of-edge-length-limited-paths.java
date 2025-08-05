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
    boolean isConnected(int x,int y){
        int parentx=find(x);
        int parenty=find(y);
        return parentx==parenty;
    }
    void union(int x,int y){
        int parentx=find(x);
        int parenty=find(y);
        if(parentx==parenty){
            return;
        }
        else{
            parent[parenty]=parentx;

        }
    }
    
}
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans=new boolean[queries.length];
        int[][] queriesModified=new int[queries.length][4];
        int idx=0;
        for(int[] a:queries){
            queriesModified[idx][0]=a[0];
            queriesModified[idx][1]=a[1];
            queriesModified[idx][2]=a[2];
            queriesModified[idx][3]=idx;
            idx++;
        }
        UnionFind uf=new UnionFind(n);
        Arrays.sort(queriesModified,(a,b)->(a[2]-b[2]));
        Arrays.sort(edgeList,(a,b)->(a[2]-b[2]));
        int i=0;
        for(int[] a:queriesModified){
            while(i<edgeList.length && edgeList[i][2]<a[2]){
                uf.union(edgeList[i][0],edgeList[i][1]);
                i++;
            }
            if(uf.isConnected(a[0],a[1])){
                ans[a[3]]=true;
            }else{
                ans[a[3]]=false;
            }

        }
        return ans;
    }
    
}