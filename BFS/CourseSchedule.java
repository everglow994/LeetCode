package BFS;

import java.util.*;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for(int[] pre: prerequisites) {
            degree[pre[0]] += 1;
            graph[pre[1]].add(pre[0]);
        }

        int[] order = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) {
                order[count++] = i;
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> ns = graph[u];
            for(Integer n: ns) {
                degree[n]--;
                if(degree[n] == 0) {
                    order[count++] = n;
                    queue.offer(n);
                }
            }
        }


        return count == numCourses ? order : new int[0];

    }




}
