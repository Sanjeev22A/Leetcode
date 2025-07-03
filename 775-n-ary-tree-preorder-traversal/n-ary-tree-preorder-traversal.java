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
    List<Integer> res;
    void traverse(Node root){
        if(root==null){
            return;
        }
        res.add(root.val);
        for(Node a:root.children){
            traverse(a);
        }
    }
    public List<Integer> preorder(Node root) {
        res=new ArrayList<>();
        traverse(root);
        return res;
    }
}