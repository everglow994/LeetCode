package Coding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HighFive {

    class Record {
        int id, score;
        Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> result = new HashMap<>();
        // Write your code here
        if(results == null || results.length == 0) {
            return result;
        }
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for(Record record: results) {
            Queue<Integer> queue = map.getOrDefault(record.id, new PriorityQueue<>());

            if(queue.size() < 5) {
                queue.offer(record.score);
            } else {
                if(queue.peek() < record.score) {
                    queue.poll();
                    queue.offer(record.score);
                }
            }

            map.put(record.id, queue);
        }

        for(Map.Entry<Integer, Queue<Integer>> entry: map.entrySet()) {
            double avg = 0;
            Queue<Integer> queue = entry.getValue();
            for(int i = 0; i < 5; i++) {
                avg += queue.poll();
            }
            avg /= 5.0;
            result.put(entry.getKey(), avg);
        }

        return result;
    }
}
