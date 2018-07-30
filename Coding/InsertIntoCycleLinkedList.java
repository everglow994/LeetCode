package Coding;

public class InsertIntoCycleLinkedList {

    class Node {
        int val;
        Node next;
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(insertVal, head);
            return head;
        }

        Node cur = head;
        do {
            if(cur.val <= insertVal && cur.next.val >= insertVal) {
                break;
            }
            if(cur.val >= cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) {
                break;
            }
            cur = cur.next;
        } while(cur != head);

        Node insert = new Node(insertVal, cur.next);
        cur.next = insert;
        return head;
    }
}
