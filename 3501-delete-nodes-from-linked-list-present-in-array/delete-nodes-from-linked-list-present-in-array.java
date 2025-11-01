/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s=new HashSet<>();
        for(int a:nums){
            s.add(a);
        }
        ListNode temp=new ListNode();
        temp.next=head;
        ListNode cur=temp;
        ListNode prev=temp;
        cur=cur.next;
        while(cur!=null){
            if(s.contains(cur.val)){
                prev.next=cur.next;
            }else{
                prev=cur;
            }
            cur=cur.next;
        }
        return temp.next;
    }
}