package Coding;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheCountMiss {

    public int Solution(int[] array, int size) {
        if (array == null || array.length == 0) {
            return 0;
        }
        List<Integer> cache = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (cache.contains(array[i])) {
                cache.remove(array[i]);
            } else {
                count++;
                if (cache.size() == size) {
                    cache.remove(0);
                }
            }
            cache.add(array[i]);
        }
        return count;
    }

    public int SolutionII(int[] array, int size) {
        if (array == null || array.length == 0) {
            return 0;
        }
        LRUCache cache = new LRUCache(size);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(cache.get(array[i]) == -1) {
                count++;
            }
            cache.put(array[i], 0);
        }
        return count;
    }

    class LRUCache {
        Map<Integer, Integer> cache;
        public LRUCache(int capacity) {
            this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            return cache.get(key);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }
}
