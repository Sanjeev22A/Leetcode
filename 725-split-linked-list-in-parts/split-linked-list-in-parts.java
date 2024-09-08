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
    public ListNode[] splitListToParts(ListNode head, int k) {
       
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        
        int branchSize=size/k;
        int remainingSize=size%k;
        ListNode prev=null;
        cur=head;
        ListNode[] arr=new ListNode[k];
        for(int i=0;i<k;i++){
            if(prev!=null){
                prev.next=null;
            }
            arr[i]=cur;
            int currentSize=branchSize+(i<remainingSize?1:0);
            for(int j=0;j<currentSize;j++){
                prev=cur;
                cur=cur.next;
            }
        }
        
        return arr;
    }
}