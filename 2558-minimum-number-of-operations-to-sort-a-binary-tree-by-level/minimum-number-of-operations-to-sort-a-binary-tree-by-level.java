import java.util.*;

class Solution {

    private int getMinSwaps(int[] arr) {
        int swaps = 0;
        int[] target = arr.clone();
        Arrays.sort(target);

        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pos.put(arr[i], i);
        }

        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || arr[i] == target[i]) {
                continue;
            }

            // Find the size of the cycle
            int cycleSize = 0;
            int x = i;

            while (!visited[x]) {
                visited[x] = true;
                x = pos.get(target[x]);
                cycleSize++;
            }

            swaps += (cycleSize - 1);
        }

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        int num = 0;

        while (!bfs.isEmpty()) {
            int levSize = bfs.size();
            int[] level = new int[levSize];

            for (int i = 0; i < levSize; i++) {
                TreeNode node = bfs.poll();
                level[i] = node.val;

                if (node.left != null) {
                    bfs.offer(node.left);
                }
                if (node.right != null) {
                    bfs.offer(node.right);
                }
            }

            num += getMinSwaps(level);
        }

        return num;
    }
}
