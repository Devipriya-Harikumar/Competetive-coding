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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        ListNode prev = head;
        while(temp != null){
            if(temp.next != null && temp.val == temp.next.val){
                while(temp.next != null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                prev.next = temp.next;
            } else {
                temp = temp.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}