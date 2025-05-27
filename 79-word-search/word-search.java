class Solution {
    int[][] movement;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                boolean flag=dfs(board,word,0,i,j,m,n);
                if(flag){
                    return flag;
                }
            }
        }
        return false;
    }
    boolean checkMemorySafe(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    boolean dfs(char[][] board,String word,int post,int i,int j,int m,int n){
        movement=new int[][] {
            {1,0},
            {-1, 0},
            {0,1},
            {0,-1}
        };
        if(post==word.length()){
            return true;
        }
        if(!checkMemorySafe(i,j,m,n)){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(word.charAt(post)!=board[i][j]){
            return false;
        }
        visited[i][j]=true;
        boolean flag=false;
        for(int[] a:movement){

            flag=flag||dfs(board,word,post+1,i+a[0],j+a[1],m,n);
            if(flag){
                System.out.println(i+":"+j+":"+board[i][j]);
            }
        }
        visited[i][j]=false;
        return flag;
    }
}