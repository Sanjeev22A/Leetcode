/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        Node cur=head;
        while(cur!=null){
            Node newCur=new Node(cur.val);
            map.put(cur,newCur);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            Node newCur=map.get(cur);
            newCur.next=map.get(cur.next);
            newCur.random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}