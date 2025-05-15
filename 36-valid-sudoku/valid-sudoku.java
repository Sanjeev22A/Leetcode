class Solution {
    int getJ(int j){
        if(j<3){
            return 0;
        }
        else if(j<6){
            return 1;
        }else{
            return 2;
        }
    }
    int getBoxIndex(int i,int j){
        if(i<3){
            return getJ(j);
        }
        else if(i<6){
            return 3+getJ(j);
        }else{
            return 6+getJ(j);
        }
    }
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> Rows=new ArrayList<>();
        List<HashSet<Character>> Cols=new ArrayList<>();
        List<HashSet<Character>> boxes=new ArrayList<>();
        for(int i=0;i<9;i++){
            Rows.add(new HashSet<>());
            Cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int idx=getBoxIndex(i,j);
                if(board[i][j]=='.'){
                    continue;
                }
                if(Rows.get(i).contains(board[i][j])){
                    System.out.println("Fails here"+i+":"+j);
                    return false;
                }else if(Cols.get(j).contains(board[i][j])){
                    
                    return false;
                }
                else if(boxes.get(idx).contains(board[i][j])){
                    
                    return false;
                }
                else{
                    Rows.get(i).add(board[i][j]);
                    Cols.get(j).add(board[i][j]);
                    boxes.get(idx).add(board[i][j]);
                }
            }
        }
        return true;
    }
}