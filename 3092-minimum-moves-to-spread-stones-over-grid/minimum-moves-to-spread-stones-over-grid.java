class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    List<List<Pair>> permute = new ArrayList<>();

    void generatePermutations(List<Pair> cur, boolean[] visited, List<Pair> excessCells, int targetSize) {
        if (cur.size() == targetSize) {
            permute.add(new ArrayList<>(cur));  
            return;
        }

        for (int i = 0; i < excessCells.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cur.add(excessCells.get(i));
            generatePermutations(cur, visited, excessCells, targetSize);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }

    public int minimumMoves(int[][] grid) {
        permute=new ArrayList<>();
        List<Pair> deficitCells=new ArrayList<>();
        List<Pair> excessCells=new ArrayList<>();
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]==0){
                    deficitCells.add(new Pair(i,j));
                }else if(grid[i][j]>1){
                    int cur=grid[i][j];
                    while(cur>1){
                        excessCells.add(new Pair(i,j));
                        cur--;
                    }
                }
            }
        }
        boolean[] visited=new boolean[deficitCells.size()];
        generatePermutations(new ArrayList<>(),visited,excessCells,deficitCells.size());
        int min=Integer.MAX_VALUE;
        for(List<Pair> arr:permute){
            int ans=0;
            for(int i=0;i<arr.size();i++){
                Pair p1=arr.get(i);
                Pair p2=deficitCells.get(i);
                ans+=Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
            }
            min=Math.min(ans,min);
        }
        return min;

        
        
    }
    
    
}