package Heap;

import java.util.*;

public class TopKLargestNumberPriorityQueue {



    // time: - O(logN) add - O(klogk) topk
    // space: - O(K)
    Queue<Integer> minheap;
    int k;

    public TopKLargestNumberPriorityQueue(int k) {
        this.k = k;
        minheap = new PriorityQueue<>();
    }

    public void add(int number) {
        if(minheap.size() < k) {
            minheap.offer(number);
            return;
        }
        if(number > minheap.peek()) {
            minheap.poll();
            minheap.offer(number);
        }
    }

    public List<Integer> topk() {
        List<Integer> res = new ArrayList<>();

        Iterator it = minheap.iterator();
        while(it.hasNext()) {
            res.add((int)it.next());
        }
        Collections.sort(res, Collections.reverseOrder());    // O(k)
        return res;
    }

}
