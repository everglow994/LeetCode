package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {


    //
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();

        // O(N) space
        Map<Character, Integer> map = new HashMap();

        // O(N) time
        for(char c: chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // O(NlogN) time O(N) space
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            maxHeap.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(Integer i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
