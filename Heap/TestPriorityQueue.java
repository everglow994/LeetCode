package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>(3);  // min heap
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        pq.offer(-2);
        for(int i = 0; i < 3; i++) {
            System.out.print(pq.poll());
        }
    }
}
