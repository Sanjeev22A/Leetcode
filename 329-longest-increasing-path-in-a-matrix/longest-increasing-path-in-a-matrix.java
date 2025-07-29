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
        return x*31+y;
    }
}
class Solution {
    int[][] dp;
    int m,n;
    boolean isMemorySafe(int i,int j,int m,int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    int dfs(Point p,int[][] matrix,int[][] dir){
        if(!isMemorySafe(p.x,p.y,m,n)){
            return 0;
        }
        if((dp[p.x][p.y]!=-1)){
            return dp[p.x][p.y];
        }
        int ans=1;
        
        for(int[] a:dir){
            if(isMemorySafe(p.x+a[0],p.y+a[1],m,n) && matrix[p.x][p.y]<matrix[p.x+a[0]][p.y+a[1]]){
                int val=dfs(new Point(p.x+a[0],p.y+a[1]),matrix,dir);
                ans=Math.max(ans,1+val);
            }
        }
        dp[p.x][p.y]=ans;
        return ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=dfs(new Point(i,j),matrix,dir);
                ans=Math.max(ans,val);
            }
        }
        return ans;

        

    }
}