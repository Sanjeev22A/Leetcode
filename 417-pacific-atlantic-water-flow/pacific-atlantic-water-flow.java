class Solution {
    int[][] dir;
    int[][] pacificMap;
    int[][] atlanticMap;
    int[][] heights;
    boolean isMemorySafe(int x,int y,int[][] box){
        if(x>=0 && x<box.length && y>=0 && y<box[0].length){
            return true;
        }
        return false;
    }
    boolean recurse(int i,int j,int[][] map){
        if(map[i][j]==1){
            return true;
        }
        
        map[i][j]=-2;
        boolean key=false;
        for(int[] a:dir){
            int ni=i+a[0];
            int nj=j+a[1];
            if(isMemorySafe(ni,nj,map) && heights[i][j]>=heights[ni][nj] && map[ni][nj]!=-2 ){
                key=key | recurse(ni,nj,map);
            }
        }
        if(key){
            map[i][j]=1;
        }else{
            map[i][j]=-1;
        }
        return key;
        
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        int m=heights.length,n=heights[0].length;
        dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        pacificMap=new int[m][n];
        atlanticMap=new int[m][n];
        for(int i=0;i<m;i++){
            pacificMap[i][0]=1;
            atlanticMap[i][n-1]=1;
        }
        for(int j=0;j<n;j++){
            pacificMap[0][j]=1;
            atlanticMap[m-1][j]=1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                recurse(i,j,pacificMap);
                recurse(i,j,atlanticMap);
                
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //System.out.println(i+":"+j+":"+pacificMap[i][j]+":"+atlanticMap[i][j]);
                if(pacificMap[i][j]==1 && atlanticMap[i][j]==1){
                    
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;

    }
}