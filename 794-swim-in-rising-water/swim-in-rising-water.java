class Point{
    int x,y;
    int val;
    Point(int x,int y,int val){
        this.x=x;
        this.y=y;
        this.val=val;
    }
}
class Solution {
    int[][] dir;
    int[][] grid;
    boolean[][] visited;
    boolean isMemorySafe(int x,int y){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length){
            return true;
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        this.dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        visited=new boolean[grid.length][grid[0].length];
        this.grid=grid;
        PriorityQueue<Point> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a.val,b.val);
        });
        pq.offer(new Point(0,0,grid[0][0]));
        
        while(!pq.isEmpty()){
            Point p=pq.poll();
            if(p.x==grid.length-1 && p.y==grid[0].length-1){
                return p.val;
            }
            if(visited[p.x][p.y]){
                continue;
            }
            visited[p.x][p.y]=true;
            for(int[] a:dir){
                int nx=p.x+a[0];
                int ny=p.y+a[1];
                if(isMemorySafe(nx,ny)){
                    pq.offer(new Point(nx,ny,Math.max(p.val,grid[nx][ny])));

                }
            }
        }
        return -1;
    }
}