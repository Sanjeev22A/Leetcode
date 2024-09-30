class Solution {
    boolean willLive(int[][] board,int i,int j){
        int[][] arr={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int count=0;
        for(int[] a:arr){
            int newI=i+a[0];
            int newJ=j+a[1];
            
            if(newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length){
                if(board[newI][newJ]==1){
                    count++;
                }
            }
            
        }
        if(board[i][j]==1){
            if(count<2){
                return false;
            }
            else if(count==2 || count==3){
                return true;
            }
            else if(count>3){
                return false;
            }
        }
        else if(board[i][j]==0){
            if(count==3){
                return true;
            }
        }
        return false;
        
    }
    public void gameOfLife(int[][] board) {
        int[][] newBoard=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                boolean val=willLive(board,i,j);
                if(val){
                    newBoard[i][j]=1;
                }
                else{
                    newBoard[i][j]=0;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=newBoard[i][j];
            }
        }
    }
}