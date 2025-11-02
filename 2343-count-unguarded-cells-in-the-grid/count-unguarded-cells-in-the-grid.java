class Solution {
    boolean isMemorySafe(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] map=new int[m][n];
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        for(int[] a:guards){
            map[a[0]][a[1]]=1;
            q.offer(a);
        }
        for(int[] a:walls){
            map[a[0]][a[1]]=-1;
        }
        while(!q.isEmpty()){
            int[] a=q.poll();
            if(map[a[0]][a[1]]==-1){
                continue;
            }
            if(map[a[0]][a[1]]==1){
                int c=2;
                for(int[] b:dir){
                    int nx=a[0]+b[0];
                    int ny=a[1]+b[1];
                    while(isMemorySafe(nx,ny,m,n) && map[nx][ny]!=-1 && map[nx][ny]!=1){
                        map[nx][ny]=c;
                        nx+=b[0];
                        ny+=b[1];
                    }
                    
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
    
                if(map[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
        
    }
}