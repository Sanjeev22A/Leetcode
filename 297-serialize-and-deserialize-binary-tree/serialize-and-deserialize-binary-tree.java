public class Codec {

    // Serializes tree using level-order traversal (with nulls as "!")
    public String serialize(TreeNode root) {
        if (root == null) return "!,";

        StringBuilder serializedTree = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                serializedTree.append("!").append(",");
            } else {
                serializedTree.append(cur.val).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }

        return serializedTree.toString();
    }

    // Deserializes level-order serialized data
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr.length == 0 || arr[0].equals("!")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode current = q.poll();

            // Left child
            if (!arr[i].equals("!")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                current.left = left;
                q.offer(left);
            }
            i++;

            // Right child
            if (i < arr.length && !arr[i].equals("!")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                current.right = right;
                q.offer(right);
            }
            i++;
        }

        return root;
    }
}
