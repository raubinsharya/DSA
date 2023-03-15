package LinkedList;

import Utils.ListNode;
// https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) head.next = list2;
        return listNode.next;
    }
}
