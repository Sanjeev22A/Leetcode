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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        
        int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int nodeDir = 0, i = 0, j = 0;
        
        while (head != null) {
            matrix[i][j] = head.val;  
            head = head.next;         
            
            
            int nextI = i + dir[nodeDir][0];
            int nextJ = j + dir[nodeDir][1];
            
            
            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || matrix[nextI][nextJ] != -1) {
                
                nodeDir = (nodeDir + 1) % 4;
                nextI = i + dir[nodeDir][0];
                nextJ = j + dir[nodeDir][1];
            }
            
            
            i = nextI;
            j = nextJ;
        }
        
        return matrix;
    }
}
