class Solution {
    char[][] board;
    boolean[][] visited;
    int m,n;
    int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    boolean isMemorySafe(int i,int j){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    void dfs(int i,int j){
        visited[i][j]=true;
        for(int[] a:dir){
            if(isMemorySafe(i+a[0],j+a[1]) &&!visited[i+a[0]][j+a[1]] && board[i+a[0]][j+a[1]]=='X'){
                
                dfs(i+a[0],j+a[1]);
            }
        }
    }
    public int countBattleships(char[][] board) {
        this.board=board;
        m=board.length;
        n=board[0].length;
        int ans=0;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    visited[i][j]=true;
                }
                if(!visited[i][j]){
                    dfs(i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}