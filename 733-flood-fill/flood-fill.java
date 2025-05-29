class Pair{
    int i,j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    boolean checkIfMoveSafe(int i,int j,int m,int n,int c,int color,int[][] image){
        if(i>=0 && i<m && j>=0 && j<n && image[i][j]==c && image[i][j]!=color){
            return true;
        }
        return false;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        int m=image.length;
        int n=image[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(sr,sc));
        int c=image[sr][sc];
        while(!q.isEmpty()){
            Pair node=q.poll();
            image[node.i][node.j]=color;
            for(int[] a:dir){
                if(checkIfMoveSafe(node.i+a[0],node.j+a[1],m,n,c,color,image)){
                    q.offer(new Pair(node.i+a[0],node.j+a[1]));
                }
            }
        }
        return image;
    }
}