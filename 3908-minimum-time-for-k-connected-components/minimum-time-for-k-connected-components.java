class Solution {
    public int minTime(int n, int[][] edges, int k) {
        if(edges==null || edges.length==0){
            if(n>=k){
                return 0;
            }
            return -1;
        }
        Arrays.sort(edges,(a,b)->(b[2]-a[2]));
        UnionFind uf=new UnionFind(n);
        int curTime=Integer.MAX_VALUE;
        int prevTime=Integer.MAX_VALUE;
        
        for(int[] a:edges){
            
            curTime=a[2];
            uf.union(a[0],a[1]);
            int components=uf.getComponents();
            if(components<k){
                break;
            }
            prevTime=curTime;
            
        }
        if(uf.getComponents()>=k){
            return 0;
        }
        
        return curTime;
    }
}

class UnionFind{
    int components;

    int[] parent;
    UnionFind(int n){
        components=n;
       
  
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    int find(int a){
        if(a==parent[a]){
            return a;
        }
        parent[a]=find(parent[a]);
        return parent[a];
    }
    void union(int a,int b){
        int parentA=find(a);
        int parentB=find(b);
        if(parentA==parentB){
            return;
        }else{
            parent[parentB]=parentA;
            components--;
        }
        
    }
    int getComponents(){
        return components;
    }
}