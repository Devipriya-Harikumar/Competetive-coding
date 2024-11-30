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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode out = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                out.next = list1;
                list1 = list1.next;
            } else {
                out.next = list2;
                list2 = list2.next;
            }
            out = out.next;
        }
        while (list1 != null) {
            out.next = list1;
            list1 = list1.next;
            out = out.next;
        }
        while (list2 != null) {
            out.next = list2;
            list2 = list2.next;
            out = out.next;
        }
        return temp.next;
    }
}
