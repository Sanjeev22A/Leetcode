class Solution {
    char[][] board;
    
    boolean isValidPlace(int x,int y,char val){
        for(int i=0;i<9;i++){
            if(board[x][i]==val){
                return false;
            }
            if(board[i][y]==val){
                return false;
            }
        }
        

        int startX = (x/3) * 3;
        int startY = (y/3) * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[startX+i][startY+j]==val){
                    return false;
                }
            }
        }
        return true;
    }
    boolean solve(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValidPlace(i,j,c)){
                            board[i][j]=c;
                            if(solve()) return true;
                            board[i][j]='.'; 
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }
    public void solveSudoku(char[][] board) {
        this.board=board;
        solve();
    }
}