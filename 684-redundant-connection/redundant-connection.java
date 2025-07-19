class UnionFind{
    int[] parent;
    int[] resEdge;
    UnionFind(int[][] edges){
        resEdge=new int[2];
        parent=new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
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
        if(parentx==parenty){
            resEdge[0]=x;
            resEdge[1]=y;
            return;
        }
        parent[parenty]=parentx;
    }
    int[] getResult(){
        return resEdge;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf=new UnionFind(edges);
        for(int[] a:edges){
            uf.union(a[0],a[1]);
        }
        return uf.getResult();
    }
}