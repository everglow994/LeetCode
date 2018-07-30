package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedListsHeap {

    // let K be the number of lists.
    // TIME:  O(NlogK)
    // Space: O(K)

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    private Comparator<ListNode> custom = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };

    public ListNode MergeKSortedArrayHeap(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int N = lists.length;
        Queue<ListNode> minheap = new PriorityQueue<>(N, custom);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for(int i = 0; i < N; i++) minheap.offer(lists[i]);
        while(!minheap.isEmpty()) {
            ListNode node = minheap.poll();
            cur.next = node;
            cur = cur.next;
            if(cur.next != null) minheap.offer(cur.next);
        }
        return dummy.next;
    }
}
