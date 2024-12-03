/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                int dup = temp.next.val;
                while (temp.val == dup && temp.next != null) {
                    temp = temp.next;
                }
                if(temp.next == null && temp.val ==dup){
                    prev.next = null;
                    break;
                }else {
                    prev.next = temp;
                }
            } else {
                temp = temp.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}