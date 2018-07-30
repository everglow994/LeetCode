package BFS;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null) {
            throw new IllegalArgumentException();
        }

        if(edges.length == 0 && n == 1) {
            return true;
        }

        // step 1 check vertex number and edge number:
        if(n != edges.length + 1) {
            return false;
        }

        // construct graph
        Map<Integer, Set<Integer>> graph = constructGraph(edges, n);

        // run bfs
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(edges[0][0]);
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            visited.add(vertex);
            for(Integer neighbour: graph.get(vertex)) {
                if(visited.contains(neighbour)) {
                   continue;
                }
                queue.offer(neighbour);
            }

        }

        return visited.size() == n;
    }

    private Map<Integer, Set<Integer>> constructGraph(int[][] edges, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
