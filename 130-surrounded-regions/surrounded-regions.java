class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    visited[i][j]=true;
                }
            }
        }

        for(int i=0;i<m;i++){
            if(!visited[i][0]){
                dfs(i,0,m,n,board,visited);
            }
            if(!visited[i][n-1]){
                dfs(i,n-1,m,n,board,visited);
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[0][i]){
                dfs(0,i,m,n,board,visited);
            }
            if(!visited[m-1][i]){
                dfs(m-1,i,m,n,board,visited);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    board[i][j]='X';
                }
            }
        }


    }
    boolean isSafe(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    void dfs(int i,int j,int m,int n,char[][] board,boolean[][] visited){
        int[][] adj = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        if(!isSafe(i,j,m,n)){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j]=true;
        for(int[] a:adj){
            int newX=i+a[0];
            int newY=j+a[1];
            if(isSafe(newX,newY,m,n) && !visited[newX][newY]){
                dfs(newX,newY,m,n,board,visited);
            }
        }

    }
}