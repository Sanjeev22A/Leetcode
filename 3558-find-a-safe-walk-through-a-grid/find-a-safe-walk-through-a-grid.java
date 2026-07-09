class Solution {
    int[][] moves={{-1,0},{1,0},{0,1},{0,-1}};
    List<List<Integer>> grid;
    Set<String> visited;
    Map<String,Boolean> cache;
    int m,n;
    boolean isSafeMove(int i,int j){
        if(i>=0 && i<m && j>=0&& j<n){
            return true;
        }
        return false;
    }
    boolean dfs(int i,int j,int health){
        String cacheKey=i+":"+j+":"+health;
        if(cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        }
        if(i==m-1 && j==n-1 && health>=1){
            return true;
        }
        if(health<1){
            return false;
        }
        boolean flag=false;
        for(int[] a:moves){
            int x=i+a[0];
            int y=j+a[1];
            String key=x+":"+y;
            if(isSafeMove(x,y) && !visited.contains(key)){
                visited.add(key);
                int val=grid.get(x).get(y);
                flag=flag | dfs(x,y,health-val);
                visited.remove(key);
            }
        }
        cache.put(cacheKey,flag);
        return flag;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        this.visited=new HashSet<>();
        cache=new HashMap<>();
        this.grid=grid;
        m=grid.size();
        n=grid.get(0).size();
        health-=grid.get(0).get(0);
        return dfs(0,0,health);
    }
}