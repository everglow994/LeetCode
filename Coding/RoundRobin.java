package Coding;

import java.util.LinkedList;
import java.util.Queue;


/**
 * return average wait time
 */

public class RoundRobin {

    static class Process {
        int arrive, execute;
        Process(int arr, int exe) {
            this.arrive = arr;
            this.execute = exe;
        }
    }
    public static float Solution(int[] Atime, int[] Etime, int q) {
        if(Atime == null || Atime.length == 0
                || Etime == null || Etime.length == 0
                || q == 0 || Atime.length != Etime.length)
            return 0f;

        int N = Atime.length;
        Queue<Process> queue = new LinkedList<>();

        int current = 0;
        int wait = 0;
        int index = 0;

        // 在这里 特别注意， 要分为栈在遍历过程中可能为空的两种分类写，
        // 因为条件1 有时候不推任何一个request在栈里面
        while(!queue.isEmpty() || index < N) {
            if(queue.isEmpty()) {
                queue.offer(new Process(Atime[index], Etime[index]));
                current = Atime[index++];
            } else {
                Process p = queue.poll();

                wait += current - p.arrive;
                current += Math.min(q, p.execute);


                // 条件1
                for(; index < N && Atime[index] <= current; index++) {
                    queue.offer(new Process(Atime[index], Etime[index]));
                }

                if(p.execute > q) {
                    queue.offer(new Process(p.arrive, p.execute - q));
                }
            }
        }


        return (float)wait / N;
    }

    public static void main(String[] args) {
        System.out.print(Solution(new int[]{0, 1, 5, 7}, new int[]{1, 2, 3, 2}, 3));
    }
}
