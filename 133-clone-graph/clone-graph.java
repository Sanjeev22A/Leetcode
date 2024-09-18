/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node deepCopy(Node node,HashMap<Integer,Node> map){
        Node copy=new Node(node.val);
        map.put(node.val,copy);
        for(Node n:node.neighbors){
            if(!map.containsKey(n.val)){
                copy.neighbors.add(deepCopy(n,map));
            }
            else{
                copy.neighbors.add(map.get(n.val));
            }
        }
        return copy;
    }
    public Node cloneGraph(Node node) {
        HashMap<Integer,Node> map=new HashMap<>();
        if(node==null){
            return null;
        }
        return deepCopy(node,map);
    }
}