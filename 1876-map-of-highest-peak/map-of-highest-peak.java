class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] result=new int[isWater.length][isWater[0].length];
        for(int i=0;i<result.length;i++){
            Arrays.fill(result[i],-1);
        }
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                if(isWater[i][j]==1){
                    result[i][j]=0;
                    queue.offer(new Pair(i,j));
                }
            }
        }
        int currentDepth=0;
        int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pair current=queue.poll();
                result[current.i][current.j]=currentDepth;
                for(int[] a:dir){
                    int x=current.i+a[0];
                    int y=current.j+a[1];
                    if(isValid(x,y,result.length,result[0].length) && result[x][y]==-1){
                        queue.offer(new Pair(x,y));
                        result[x][y]=-2;
                    }
                }
                
            }
            currentDepth++;
        }
        return result;
    }

    boolean isValid(int i,int j,int row,int col){
        if(i>=row || j>=col || i<0 || j<0){
            return false;
        }
        return true;
    }
    class Pair{
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}