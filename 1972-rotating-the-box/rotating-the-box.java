class Solution {
    void rotate(int m,int j,char[] row,char[][] newGrid){
        int nextFree=row.length-1;
        for(int i=row.length-1;i>=0;i--){
            if(row[i]=='*'){
                nextFree=i-1;
            }else if(row[i]=='#'){
                if(i!=nextFree){
                    row[nextFree]=row[i];
                    row[i]='.';
                }
                nextFree--;
            }
        }
        for(int i=0;i<row.length;i++){
            newGrid[i][m-j-1]=row[i];
        }
    }
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        char[][] ans=new char[n][m];
        for(int i=0;i<m;i++){
            rotate(m,i,boxGrid[i],ans);
        }
        return ans;
    }
}