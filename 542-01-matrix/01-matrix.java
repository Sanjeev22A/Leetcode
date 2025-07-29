class Point{
    int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(!(o instanceof Point)){
            return false;
        }
        Point temp=(Point)o;
        return temp.x==x && temp.y==y;
    }
    @Override
    public int hashCode(){
        return 31*x+y;
    }
}
class Solution {
    boolean isMemorySafe(int x,int y,int m,int n){
        if(x>=0 && x<m && y>=0 && y<n){
            return true;
        }
        return false;
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m=mat.length;
        int n=mat[0].length;
        Queue<Point> q=new LinkedList<>();
        Set<Point> visited=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    Point p=new Point(i,j);
                    q.offer(p);
                }
                
            }
        }
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Point cur=q.poll();
                
                if(visited.contains(cur)){
                    continue;
                }
                mat[cur.x][cur.y]=steps;
                
                visited.add(cur);
                for(int[] a:dir){
                    int tempX=cur.x+a[0];
                    int tempY=cur.y+a[1];
                    if(isMemorySafe(tempX,tempY,m,n)){
                        Point p=new Point(tempX,tempY);
                        if(!visited.contains(p)){
                        
                            q.offer(p);
                        }
                    }
                }
            }
           
            steps++;
        }
        return mat;
    }
}