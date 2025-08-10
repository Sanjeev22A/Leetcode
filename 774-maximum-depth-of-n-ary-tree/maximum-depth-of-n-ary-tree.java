/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int depth=0;
    void dfs(Node root,int d){
        if(root!=null){
            depth=Math.max(depth,d);
            for(Node a:root.children){
                dfs(a,d+1);
            }
        }
    }
    public int maxDepth(Node root) {

        dfs(root,1);
        return depth;
    }
}