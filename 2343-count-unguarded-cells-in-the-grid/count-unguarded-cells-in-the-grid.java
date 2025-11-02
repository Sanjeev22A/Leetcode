class Solution {
    boolean isMemorySafe(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] map=new int[m][n];
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        
        
        for(int[] a:walls){
            map[a[0]][a[1]]=-1;
        }
        for(int[] a:guards){
            map[a[0]][a[1]]=1;
        }
        for(int[] a:guards){
            
            for(int i=a[0]+1;i<m;i++){
                if(map[i][a[1]]!=-1 && map[i][a[1]]!=1){
                    map[i][a[1]]=2;
                }else{
                    break;
                }
            }
            for(int i=a[0]-1;i>=0;i--){
                if(map[i][a[1]]!=-1 && map[i][a[1]]!=1){
                    map[i][a[1]]=2;
                }else{
                    break;
                }
            }
            for(int j=a[1]+1;j<n;j++){
                if(map[a[0]][j]!=-1 && map[a[0]][j]!=1){
                    map[a[0]][j]=2;
                }else{
                    break;
                }
            }
            for(int j=a[1]-1;j>=0;j--){
                if(map[a[0]][j]!=-1 && map[a[0]][j]!=1){
                    map[a[0]][j]=2;
                }else{
                    break;
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