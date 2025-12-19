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
        if(parentx==parenty){
            return;
        }
        if(parentx<parenty){
            parent[parenty]=parentx;
        }
        else{
            parent[parentx]=parenty;
        }
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        TreeMap<Integer,List<int[]>> batches=new TreeMap<>((a,b)->{
            return Integer.compare(a,b);
        });
        for(int[] a:meetings){
            if(!batches.containsKey(a[2])){
                batches.put(a[2],new ArrayList<>());

            }
            batches.get(a[2]).add(a);
        }
        List<Integer> ans=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        ans.add(0);
        ans.add(firstPerson);
        set.add(0);
        set.add(firstPerson);
        
        UnionFind uf=new UnionFind(n);
        uf.union(0,firstPerson);

        for(Map.Entry<Integer,List<int[]>> a:batches.entrySet()){
           
            for(int[] b:a.getValue()){
                uf.union(b[0],b[1]);
            }
            for(int[] b:a.getValue()){
                
                int parent=uf.find(b[0]);
                if(parent==uf.find(0)){
                    if(!set.contains(b[0])){
                        set.add(b[0]);
                        ans.add(b[0]);
                        
                    }
                    if(!set.contains(b[1])){
                        set.add(b[1]);
                        ans.add(b[1]);
                    }
                }else{
                    uf.parent[b[0]]=b[0];
                    uf.parent[b[1]]=b[1];
                }
                
            }
        }
        return ans;

        
    }
}