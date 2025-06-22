/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    int carry = 0;
    struct ListNode *l3 = NULL, *tail = NULL;

    while (l1 || l2 || carry) {
        int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
        int digit = sum % 10;
        carry = sum / 10;

        struct ListNode *newNode = (struct ListNode *)malloc(sizeof(struct ListNode));
        newNode->val = digit;
        newNode->next = NULL;

        if (tail) {
            tail->next = newNode;
            tail = newNode;
        } else {
            l3 = tail = newNode;
        }

        if (l1) l1 = l1->next;
        if (l2) l2 = l2->next;
    }

    return l3;
}