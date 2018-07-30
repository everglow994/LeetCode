package Heap;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedListsMergeTwo {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // time: O(NlogK)
    // space: O(K)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        List<ListNode> ans = new ArrayList();    // ans space, storing pointers: O(K/2 + K/4 + K/8 + .... + 1) = O(K)
        for(int i = 0; i < lists.length; i += 2) {
            if(i + 1 < lists.length) {
                ans.add(mergeTwo(lists[i], lists[i + 1]));
                continue;
            }
            ans.add(lists[i]);
        }
        return mergeKLists(ans.toArray(new ListNode[ans.size()]));     // O(logK) stack depth
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
