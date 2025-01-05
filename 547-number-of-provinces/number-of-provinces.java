class Solution {
    int num=0;
    boolean[] visited;
    public void dfs(int[][] isConnected,boolean[] visited,int index){
        
        visited[index]=true;
        for(int i=0;i<isConnected[index].length;i++){
            if(isConnected[index][i]==1 && !visited[i]){
                dfs(isConnected,visited,i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        visited=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]){
                continue;
            }
            num++;
            dfs(isConnected,visited,i);
        }
        
        return num;
    }
}