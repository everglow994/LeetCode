package Heap;


public class MergeKSortedListsDivideConquer {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    // time: O(NlogK);
    // space: O(K);
    public ListNode mergeKSortedArrayHeap(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }


    public ListNode merge(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];
        int mid = (start + end) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);     // recursion depth: O(logK)
        return mergeTwo(left, right);
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);     // dummy nodes: 1 + 2 + 4 + 8 + .... + K = O(K)
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {         // merge 2 lists: O(N);
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;
        return dummy.next;
    }
}
