class Solution {
    int[] dp;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] a:richer){
            graph.get(a[1]).add(a[0]);  //we traverse from the poor to the rich person
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=dfs(i,graph,quiet);
        }
        return ans;

    }
    int dfs(int person,List<List<Integer>> graph,int[] quiet){
        if(dp[person]!=-1){
            return dp[person];
        }
        int quietPerson=person;
        for(int a:graph.get(person)){
            int minPerson=dfs(a,graph,quiet);
            if(quiet[minPerson]<quiet[quietPerson]){
                quietPerson=minPerson;
            }
        }
        dp[person]=quietPerson;
        return dp[person];
    }
}