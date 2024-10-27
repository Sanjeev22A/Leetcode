class Solution {
    int[][] addMatrix;
    void makeAddMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                addMatrix[i][j]=matrix[i][j];
                if(i-1>=0){
                    addMatrix[i][j]+=addMatrix[i-1][j];
                }
                if(j-1>=0){
                    addMatrix[i][j]+=addMatrix[i][j-1];
                }
                if(i>0 && j>0){
                    addMatrix[i][j]-=addMatrix[i-1][j-1];
                }
                System.out.print(addMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    boolean isTrue(int[][] matrix,int i,int j,int size){
        int getSum=addMatrix[i+size-1][j+size-1];
        if(i>0 && j>0) getSum+=addMatrix[i-1][j-1];
        if(i>0) getSum-=addMatrix[i-1][j+size-1];
        if(j>0) getSum-=addMatrix[i+size-1][j-1];
        return getSum==size*size?true:false;
    }
    int logic(int[][] matrix){
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                for(int size=1;i+size<=matrix.length && j+size<=matrix[0].length;size++){
                    if(isTrue(matrix,i,j,size)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int countSquares(int[][] matrix) {
        addMatrix=new int[matrix.length][matrix[0].length];
        makeAddMatrix(matrix);
        return logic(matrix);
    }
}