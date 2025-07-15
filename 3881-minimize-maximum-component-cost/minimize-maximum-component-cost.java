class UnionFind{
    int[] parent;
    int numComponents;
    
    UnionFind(int n){
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        numComponents=n;
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
            numComponents--;
            parent[parenty]=parentx;
        }
    }
    int getNumComponents(){
        return numComponents;
    }
}
class Solution {
    public int minCost(int n, int[][] edges, int k) {
        Arrays.sort(edges,(a,b)->(a[2]-b[2]));
        UnionFind uf=new UnionFind(n);
        int maxEdgeWeight=0;
        int prevMaxEdgeWeight=0;
        for(int[] a:edges){
            if(uf.getNumComponents()<=k){
                break;
            }
            uf.union(a[0],a[1]);
            prevMaxEdgeWeight=maxEdgeWeight;
            maxEdgeWeight=Math.max(a[2],maxEdgeWeight);
            //System.out.println(prevMaxEdgeWeight+":"+maxEdgeWeight+":"+uf.getNumComponents());
        }
        if(k==uf.getNumComponents()){
            return maxEdgeWeight;
        }
        return prevMaxEdgeWeight;

    }
}