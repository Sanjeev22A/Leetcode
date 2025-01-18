class Solution {
    public int minCost(int[][] grid) {
        int numRows=grid.length;
        int numCols=grid[0].length;
        int[][] minCost=new int[numRows][numCols];
        for(int i=0;i<numRows;i++){
            Arrays.fill(minCost[i],Integer.MAX_VALUE);

        }
        minCost[0][0]=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> queue=new ArrayDeque<>();
        queue.offerFirst(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] cur=queue.pollFirst();
            int i=1;
            for(int[] a:dirs){
                int newRow=cur[0]+a[0];
                int newCol=cur[1]+a[1];
                if(isValid(newRow,newCol,numRows,numCols)){
                    int cost;
                    if(i==grid[cur[0]][cur[1]]){
                        cost=0;
                    }
                    else{
                        cost=1;
                    }
                    if(minCost[newRow][newCol]>minCost[cur[0]][cur[1]]+cost){
                        minCost[newRow][newCol]=minCost[cur[0]][cur[1]]+cost;
                        if(cost==1){
                        queue.offerLast(new int[]{newRow,newCol});
                    }
                    else{
                        queue.offerFirst(new int[]{newRow,newCol});
                    }
                    }
                    
                }
                i++;

            }

        }
        return minCost[numRows-1][numCols-1];
        
    }

    private boolean isValid(int i,int j,int row,int col){
        if(i<0 || j<0 || i>=row || j>=col){return false;}
        return true;
    }
}