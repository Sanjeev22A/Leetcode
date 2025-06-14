
class Solution {
    Set<String> set;
    boolean[] visited;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        set=new HashSet<>();
        visited=new boolean[hasApple.size()];
        List<List<Integer>> tree=new ArrayList<>();
        for(int i=0;i<hasApple.size();i++){
            tree.add(new ArrayList<>());
        }
        for(int[] a:edges){
            tree.get(a[0]).add(a[1]);
            tree.get(a[1]).add(a[0]);
            
        }
        dfs(0,tree,hasApple);
        return set.size()*2;
    }

    boolean dfs(int node,List<List<Integer>> tree,List<Boolean> hasApple){
        if(visited[node]){
            return hasApple.get(node);
        }
        visited[node]=true;
        boolean flag=false;
        for(int a:tree.get(node)){
            if(visited[a]){
                continue;
            }
            if(dfs(a,tree,hasApple)){
                
                flag=true;
              
                set.add(node+":"+a);
            }
        }
        if(flag || hasApple.get(node)){
            hasApple.set(node,true);
            return true;
        }
        return false;
    }
}