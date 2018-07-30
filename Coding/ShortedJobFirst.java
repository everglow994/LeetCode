package Coding;

import java.util.PriorityQueue;
import java.util.Queue;

/**
一个处理器要处理一堆request，一次只能处理一条，
如果它有几个积压着的requests，它会先执行持续时间短的那个；对于持续时间相等的requests，
先执行最早到达处理器的request。问平均每个request要等多久才能被处理。
input：requestTimes[]，每个request到达处理器的时间; durations[]
每个request要处理的持续时间。 两个数组是一一对应的，并已按requestTimes[] 从小到大排序过
 */

public class ShortedJobFirst {


    class Process {
        int arrive;
        int duration;
        Process(int arrive, int duration) {
            this.arrive = arrive;
            this.duration = duration;
        }
    }
    public float Solution(int[] req, int[] dur) {
        // invalid input
        if(req == null || req.length == 0 || dur.length != req.length) {
            return 0f;
        }

        Queue<Process> queue = new PriorityQueue<>((Process p1, Process p2) -> {
            if(p1.duration != p2.duration) {
                return p1.duration - p2.duration;
            } else {
                return p1.arrive - p2.arrive;
            }
        });

        int N = req.length;
        int index = 0;
        int current = 0;
        int wait = 0;
        while(!queue.isEmpty() || index < N) {
            if(queue.isEmpty()) {
                queue.offer(new Process(req[index], dur[index]));
                current = req[index++];
            } else {
                Process p = queue.poll();
                wait += current - p.arrive;
                current += p.duration;
                for(; index < N && req[index] <= current; index++) {
                    queue.offer(new Process(req[index], dur[index]));
                }
            }
        }
        return (float)wait / N;
    }
}
