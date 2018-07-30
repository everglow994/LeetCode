package Heap;

import java.util.*;

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;

        Map<String, Integer> map = new HashMap<>();
        for(String s: words) map.put(s, map.getOrDefault(s, 0) + 1);

        Queue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a, String b) {
                if(map.get(a).equals(map.get(b))) {
                    return b.compareTo(a);
                } else {
                    return map.get(a) - map.get(b);
                }
            }
        });

        for(String s: map.keySet()) {
            // 千万注意相等的情况
            // 在这里为什么一定要这么写？？
            // 因为在这里有考虑到不同的词汇有同样的频率， 一定要先放进去，然后根据其他条件来判断
            minHeap.offer(s);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
