import java.util.*;

class Solution {

    boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && j >= 0 && i < row && j < col;
    }

    int dfs(int i, int j, int islandId, Map<Pair, Integer> map, int[][] grid, boolean[][] visited) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        if (!isValid(i, j, grid.length, grid[0].length) || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        map.put(new Pair(i, j), islandId);
        visited[i][j] = true;
        int length = 1; // Count the current cell

        for (int[] d : dir) {
            int row = i + d[0];
            int col = j + d[1];
            length += dfs(row, col, islandId, map, grid, visited);
        }
        return length;
    }

    public int largestIsland(int[][] grid) {
        Map<Pair, Integer> map = new HashMap<>();
        Map<Integer, Integer> lenMap = new HashMap<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandId = 1;
        int maxIslandSize = 0;

        // Find all islands and store their sizes
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j, islandId, map, grid, visited);
                    lenMap.put(islandId, size);
                    maxIslandSize = Math.max(maxIslandSize, size);
                    islandId++;
                }
            }
        }

        // Try changing each 0 to 1 and check the new island size
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    int newSize = 1;

                    for (int[] d : new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}) {
                        int row = i + d[0];
                        int col = j + d[1];

                        if (isValid(row, col, grid.length, grid[0].length) && grid[row][col] == 1) {
                            int id = map.get(new Pair(row, col));
                            if (uniqueIslands.add(id)) {
                                newSize += lenMap.get(id);
                            }
                        }
                    }
                    maxIslandSize = Math.max(maxIslandSize, newSize);
                }
            }
        }

        return maxIslandSize;
    }

    class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
