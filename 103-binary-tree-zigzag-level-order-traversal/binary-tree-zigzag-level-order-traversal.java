class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        boolean leftToRight = true;

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode node = dq.pollFirst();
                    levelNodes.add(node.val);
                    if (node.left != null) dq.addLast(node.left);
                    if (node.right != null) dq.addLast(node.right);
                } else {
                    TreeNode node = dq.pollLast();
                    levelNodes.add(node.val);
                    // Note: add right first, then left — for correct next-level order
                    if (node.right != null) dq.addFirst(node.right);
                    if (node.left != null) dq.addFirst(node.left);
                }
            }
            res.add(levelNodes);
            leftToRight = !leftToRight;
        }

        return res;
    }
}
