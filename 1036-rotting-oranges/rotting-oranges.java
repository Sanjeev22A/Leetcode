class Solution {
    class Node {
        int a, b, c;
        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return a == node.a && b == node.b;  // Compare based on 'a' and 'b'
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);  // Compute hash based on 'a' and 'b'
        }
     
    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> MainQueue = new LinkedList<>();
        Queue<Node> BFSQueue = new LinkedList<>();
        boolean flag=false;
        // Initialization of MainQueue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    MainQueue.add(new Node(i, j, grid[i][j]));  // Corrected the method call
                }
                if(grid[i][j]!=0){
                    flag=true;
                }
            }
        }

        if(!flag){
            return 0;
        }
        int count = 0;
        int[][] neigh = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  // Corrected array initialization
        HashSet<Node> visited = new HashSet<>();

        // BFS logic to traverse the grid
        while (!MainQueue.isEmpty()) {
            while (!MainQueue.isEmpty()) {
                Node cur = MainQueue.poll();  // Corrected method from 'pop' to 'poll'
                visited.add(cur);
                System.out.println(cur.a+" "+cur.b);
                grid[cur.a][cur.b] = 0;  // Rotting the orange

                for (int[] val : neigh) {
                    int newA = cur.a + val[0];
                    int newB = cur.b + val[1];

                    // Check if the new coordinates are within bounds
                    if (newA >= 0 && newA < grid.length && newB >= 0 && newB < grid[0].length) {
                        Node newNode = new Node(newA, newB, grid[newA][newB]);

                        // Check if the node has not been visited and is a fresh orange (value == 1)
                        if (!visited.contains(newNode) && grid[newA][newB] == 1) {
                            grid[newA][newB]=2;
                            newNode.c=2;
                            BFSQueue.add(newNode);
                        }
                    }
                }
            }
            if(BFSQueue.isEmpty()){
                break;
            }
            System.out.println();
            count++;
            // Move elements from BFSQueue to MainQueue
            while (!BFSQueue.isEmpty()) {
                MainQueue.add(BFSQueue.poll());  // Corrected BFSQueue instead of 'BFS'
            }

        }

        // Check for any remaining fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;  // Return -1 if there are any fresh oranges left
                }
            }
        }

        return count;
    }
}