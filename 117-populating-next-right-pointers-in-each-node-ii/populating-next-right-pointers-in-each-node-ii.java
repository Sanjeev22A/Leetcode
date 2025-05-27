/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        if(root==null){
            return root;
        }
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                Node r=q.poll();
                if(i!=s-1){
                    r.next=q.peek();
                }
                if(r.left!=null){
                    q.offer(r.left);
                }
                if(r.right!=null){
                    q.offer(r.right);
                }
            }
        }
        return root;
        
    }
}