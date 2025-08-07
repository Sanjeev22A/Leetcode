class Solution {
    int m,n;
    int[][] dir;
    boolean isMemorySafe(int i,int j){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    boolean isBorder(int i,int j){
        if(i==0 || i==m-1 || j==0 || j==n-1){
            return true;
        }
        return false;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        m=maze.length;
        n=maze[0].length;
        dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        Queue<int[]> q=new LinkedList<>();
        q.offer(entrance);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] p=q.poll();
                visited[p[0]][p[1]]=true;
                for(int[] a:dir){
                    int tempx=p[0]+a[0];
                    int tempy=p[1]+a[1];
                    if(isMemorySafe(tempx,tempy) && maze[tempx][tempy]!='+' && !visited[tempx][tempy]){
                        if(isBorder(tempx,tempy)){
                            return count+1;
                        }
                        
                        q.offer(new int[]{tempx,tempy});
                    }
                    if(isMemorySafe(tempx,tempy)){
                        visited[tempx][tempy]=true;
                    }
                    
                }
            }
            count++;
        }
        return -1;

    }
}