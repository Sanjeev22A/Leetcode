class Solution {
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}}; 

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        int i = 0, j = 0, d = 0; 
        for (int num = 1; num <= n * n; num++) {
            matrix[i][j] = num;
            visited[i][j] = true;

            int ni = i + dir[d][0];
            int nj = j + dir[d][1];

            if (ni < 0 || nj < 0 || ni >= n || nj >= n || visited[ni][nj]) {
                d = (d + 1) % 4; 
                ni = i + dir[d][0];
                nj = j + dir[d][1];
            }

            i = ni;
            j = nj;
        }

        return matrix;
    }
}
