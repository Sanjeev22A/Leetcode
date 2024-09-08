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
        
        
        int eachSize = size / k;
        int extraParts = size % k;
        
        
        ListNode[] result = new ListNode[k];
        cur = head;
        
        for (int i = 0; i < k; i++) {
            ListNode partHead = cur;
            ListNode prev = null;
            
            
            int currentPartSize = eachSize + (i < extraParts ? 1 : 0);
            
         
            for (int j = 0; j < currentPartSize; j++) {
                prev = cur;
                if (cur != null) cur = cur.next;
            }
            
            
            if (prev != null) prev.next = null;
            
            
            result[i] = partHead;
        }
        
        return result;
    }
}