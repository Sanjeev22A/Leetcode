class Solution {
    int dfs(int node,List<List<Integer>> subOrdinate,int[] informTime){
        if(subOrdinate.get(node).size()==0){
            return 0;
        }
        else{
            int v1=0;
            for(int a:subOrdinate.get(node)){
                v1=Math.max(v1,dfs(a,subOrdinate,informTime));
            }
            return v1+informTime[node];
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> subOrdinates=new ArrayList<>();
        List<Integer> start=new ArrayList<>();

        for(int i=0;i<n;i++){
            subOrdinates.add(new ArrayList<>());
        }
        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1){
                subOrdinates.get(manager[i]).add(i);
            }
            else{
                start.add(i);
            }
        }
        int ans=0;
        for(int a:start){
            ans=Math.max(dfs(a,subOrdinates,informTime),ans);
        }
        return ans;

    }
}