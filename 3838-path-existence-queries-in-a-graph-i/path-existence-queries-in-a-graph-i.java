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
    }
    boolean isConnected(int x,int y){
        return find(x)==find(y);
    }

}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] pairs=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            pairs[i][0]=nums[i];
            pairs[i][1]=i;
        }
        Arrays.sort(pairs,(a,b)->(a[0]-b[0]));
        UnionFind uf=new UnionFind(n);
        //We compare only the nearby components for a reason
        //Case 1: lets say a,b,c are neighbours if a-b edge exist then b-a<maxDiff and if c-b exist c-b<maxDiff and now a is connected to c via b irrespective of whether c-a<=maxDiff
        //Case 2: lets say a,b,c are neighbours where b-a <=maxDiff and c-b>maxDiff so c-b doesnt exist this means c-a>maxDiff as a<b
        //so c-a also doesnt exist and thus holds true
        for(int i=0;i<pairs.length-1;i++){
            if(pairs[i+1][0]-pairs[i][0]<=maxDiff){
                uf.union(pairs[i+1][1],pairs[i][1]);
            }
        }
        boolean[] ans=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            if(uf.isConnected(a,b)){
                ans[i]=true;
            }else{
                ans[i]=false;
            }
        }
        return ans;
    }
}