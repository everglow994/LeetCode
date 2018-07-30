package Coding;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {


    class RandomListNode {
       int label;
       RandomListNode next, random;
       RandomListNode(int x) { this.label = x; }
   }

    // constant space
    // 思想是 1-2-3 先变成 1-1'-2-2'-3-3' 然后copy random指针 最后分离
    public RandomListNode copy(RandomListNode head) {
        // write your code here
        if(head == null) {
            return null;
        }

        RandomListNode cur = head;

        while(cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            copy.random = cur.random;
            cur = cur.next.next;
        }

        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy = dummy;
        while(cur != null) {
            copy.next = cur.next;
            cur.next = copy.next.next;
            cur = cur.next;
            copy = copy.next;
        }

        return dummy.next;
    }

    // with hash map
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null)
            return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;
        RandomListNode curHead = map.get(cur);
        RandomListNode curCopy = curHead;
        while(cur != null) {
            curCopy.next = map.get(cur.next);
            curCopy.random = map.get(cur.random);
            cur = cur.next;
            curCopy = curCopy.next;
        }

        return curHead;
    }
}
