class NumMatrix {
    int[][] sumMatrix;
    int[][] matrix;
    private void makeSumMatrix(){
        
        sumMatrix=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            if(i==0){
                sumMatrix[i][0]=matrix[i][0];
            }else{
                sumMatrix[i][0]=sumMatrix[i-1][0]+matrix[i][0];
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(j==0){
                sumMatrix[0][j]=matrix[0][j];
            }else{
                sumMatrix[0][j]=sumMatrix[0][j-1]+matrix[0][j];
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                sumMatrix[i][j]=sumMatrix[i][j-1]+sumMatrix[i-1][j]-sumMatrix[i-1][j-1]+matrix[i][j];
            }
        }
    }
    public NumMatrix(int[][] matrix) {
        
        this.matrix=matrix;
        makeSumMatrix();
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int cur=sumMatrix[row2][col2];
        int bottom=row1>0?sumMatrix[row1-1][col2]:0;
        int left=col1>0?sumMatrix[row2][col1-1]:0;
        int slide=row1>0 && col1>0?sumMatrix[row1-1][col1-1]:0;
        return cur-bottom-left+slide;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */