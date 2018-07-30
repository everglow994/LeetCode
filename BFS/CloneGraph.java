package BFS;


import java.util.*;

public class CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }


    // 1. bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        // copy every vertices
        List<UndirectedGraphNode> vertices = getNode(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode vertex: vertices) {
            mapping.put(vertex, new UndirectedGraphNode(vertex.label));
        }

        // connect every copied nodes together
        for(UndirectedGraphNode vertex: vertices) {
            UndirectedGraphNode copy = mapping.get(vertex);
            for(UndirectedGraphNode adj: vertex.neighbors) {
                UndirectedGraphNode adjcopy = mapping.get(adj);
                copy.neighbors.add(adjcopy);
            }
        }
        return mapping.get(node);

    }

    private List<UndirectedGraphNode> getNode(UndirectedGraphNode node) {
        List<UndirectedGraphNode> result = new ArrayList<>();
        if(node == null) {
            return result;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        while(!queue.isEmpty()) {
            // copy every node
            UndirectedGraphNode v = queue.poll();
            result.add(v);
            // connecting copied vertices
            for(UndirectedGraphNode neighbour: v.neighbors) {
                if(visited.contains(neighbour)) {
                    continue;
                }
                queue.offer(neighbour);
                visited.add(neighbour);
            }

        }
        return result;
    }
}
