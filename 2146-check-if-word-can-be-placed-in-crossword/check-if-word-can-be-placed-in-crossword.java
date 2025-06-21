class Solution {
    boolean in(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for (int[] d : dir) {
                    int x = i, y = j;
                    int prevX = x - d[0], prevY = y - d[1];

                    if (in(board, prevX, prevY) && board[prevX][prevY] != '#') continue;

                    int idx = 0;
                    while (idx < word.length() && in(board, x, y) &&
                           (board[x][y] == ' ' || board[x][y] == word.charAt(idx))) {
                        idx++;
                        x += d[0];
                        y += d[1];
                    }

                    
                    if (idx == word.length() && (!in(board, x, y) || board[x][y] == '#')) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
