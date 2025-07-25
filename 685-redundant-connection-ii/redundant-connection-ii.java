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
    Candidate build(int[][] edges,Candidate ignore){
        if(ignore==null){
            for(int[] a:edges){
                Candidate temp=union(a[0],a[1]);
                if(temp!=null){
                    return temp;
                }
            }
        }else{
            for(int[] a:edges){
                if(a[0]!=ignore.x || a[1]!=ignore.y){
                    Candidate temp=union(a[0],a[1]);
                    if(temp!=null){
                        return temp;
                    }
                }
            }
        }
        return null;
    }
    Candidate union(int x,int y){
        int parentx=find(x);
        int parenty=find(y);
        if(parentx==parenty){
            return new Candidate(x,y);
        }
        parent[parenty]=parentx;
        return null;
    }
}
class Candidate{
    int x,y;
    Candidate(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        Candidate c1=null,c2=null;
        for(int[] e:edges){
            if(parent[e[1]]!=0){
                c1=new Candidate(parent[e[1]],e[1]);
                c2=new Candidate(e[0],e[1]);
            }
            parent[e[1]]=e[0];
        }

        if(c1!=null){
            UnionFind uf=new UnionFind(edges.length+1);
            Candidate ans=uf.build(edges,c2);
            if(ans!=null){
                return new int[]{c1.x,c1.y};
            }else{
                return new int[]{c2.x,c2.y};
            }

        }else{
            UnionFind uf=new UnionFind(edges.length+1);
            
            Candidate ans=uf.build(edges,null);
            return new int[]{ans.x,ans.y};
        }
    }
}