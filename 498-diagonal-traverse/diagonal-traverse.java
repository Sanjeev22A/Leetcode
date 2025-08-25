class Solution {
    public static ArrayList<Integer> upwardDiagonal(int[][] mat, int sr, int sc){
        ArrayList<Integer> ans = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < n; i++){
            int x = sr - i;
            int y = sc + i;
            if( x < 0 || y >= n) break;
            ans.add(mat[x][y]);
        }
        return ans;
    }
    public static ArrayList<Integer> downwardDiagonal(int[][] mat, int sr, int sc){
        ArrayList<Integer> ans = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < n; i++){
            int x = sr + i;
            int y = sc - i;
            if( x >= m || y < 0) break;
            ans.add(mat[x][y]);
        }
        return ans;
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < m + n - 1; i++){
            if(i % 2 == 0){
                int sx = Math.min(i, n - 1);
                int sy = i - sx;
                ans.addAll(upwardDiagonal(mat, sx, sy));
            }
            else{
                int sy = Math.min(i, m - 1);
                int sx = i - sy;
                ans.addAll(downwardDiagonal(mat, sx, sy));
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}