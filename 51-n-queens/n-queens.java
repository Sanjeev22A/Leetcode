class Solution {
    private List<List<String>> solutions = new ArrayList<>();
    
    private int[] columns;
    private int[] diagonals;
    private int[] antiDiagonals;

    private String[][] board;
    private int size;

    public List<List<String>> solveNQueens(int n) {
        this.size=n;
        columns=new int[n];
        diagonals=new int[2*n];
        antiDiagonals=new int[2*n];
        board=new String[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],".");

        }
        depthFirstSearch(0);
        return solutions;
    }
    private void depthFirstSearch(int row) { // Backtracking
        // If all queens are placed
        if (row == size) {
            List<String> oneSolution = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                // Join the row to form the string
                oneSolution.add(String.join("", board[i]));
            }
            // Add the current board configuration to the solutions list
            solutions.add(oneSolution);
            return;
        }
        // Iterate through each column for the current row
        for (int col = 0; col < size; ++col) {
            // Check if the current position is safe for placing a queen
            if (columns[col] + diagonals[row + col] + antiDiagonals[size - row + col] == 0) {
                // Place the queen
                board[row][col] = "Q";
                // Mark current column, diagonal, and anti-diagonal as occupied
                columns[col] = diagonals[row + col] = antiDiagonals[size - row + col] = 1;
                // Continue to place the next queen
                depthFirstSearch(row + 1);
                // Backtrack and remove the queen
                columns[col] = diagonals[row + col] = antiDiagonals[size - row + col] = 0;
                board[row][col] = ".";
            }
        }
    }
}