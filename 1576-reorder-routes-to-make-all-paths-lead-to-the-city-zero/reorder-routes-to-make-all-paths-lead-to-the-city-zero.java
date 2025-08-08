class Solution {
    int count=0;
    Map<Integer,List<int[]>> map;
    boolean[] visited;
    void dfs(int node){
        visited[node]=true;
        if(!map.containsKey(node)){
            return;
        }

        for(int[] a:map.get(node)){
            if(a[0]==node && !visited[a[1]]){
                count++;
                visited[a[1]]=true;
                dfs(a[1]);
            }else if(!visited[a[0]]){
                visited[a[0]]=true;
                dfs(a[0]);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        visited=new boolean[n];
        map=new HashMap<>();
        for(int[] a:connections){
            if(!map.containsKey(a[0])){
                map.put(a[0],new ArrayList<>());

            }
            if(!map.containsKey(a[1])){
                map.put(a[1],new ArrayList<>());
            }
            List<int[]> e=map.get(a[0]);
            e.add(a);
            e=map.get(a[1]);
            e.add(a);
        }
        dfs(0);
        return count;
    }
}