/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String Queuer(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur==null){
                sb.append("!,");
            }else{
                sb.append(cur.val+",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return Queuer(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] arr=data.split(",");
        if(arr.length==0 || arr[0].equals("!")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int index=1;
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(index>=arr.length){
                break;
            }
            if(!arr[index].equals("!")){
                cur.left=new TreeNode(Integer.parseInt(arr[index]));
                q.offer(cur.left);
            }
            else{
                cur.left=null;
                
            }
            index++;
            if(index>=arr.length){
                break;
            }
            if(!arr[index].equals("!")){
                cur.right=new TreeNode(Integer.parseInt(arr[index]));
                q.offer(cur.right);
            }else{
                cur.right=null;
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));