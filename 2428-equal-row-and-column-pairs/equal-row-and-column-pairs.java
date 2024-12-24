class Solution {
    public int equalPairs(int[][] grid) {
        List<List<Integer>> rows=new ArrayList<>();
        List<List<Integer>> cols=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            List<Integer> r=new ArrayList<>();
            for(int j=0;j<grid[i].length;j++){
                r.add(grid[i][j]);
            }
            rows.add(r);
        }
        for(int i=0;i<grid[0].length;i++){
            List<Integer> c=new ArrayList<>();
            for(int j=0;j<grid.length;j++){
                c.add(grid[j][i]);
            }   
            cols.add(c);
        }
        int count=0;
        for(int i=0;i<rows.size();i++){
            for(int j=0;j<cols.size();j++){
                if(rows.get(i).equals(cols.get(j))){
                    count++;
                }
            }
        }
        return count;
    }
}