package Coding;

import java.util.*;

/**
 * tag: Amazon OA, Hard
 */

public class MinimumSpanningTree {


//    // prim's greedy algorithm to obtain minimum spanning tree
//    public class Connection {
//     public String city1, city2;
//     public int cost;
//     public Connection(String city1, String city2, int cost) {
//         this.city1 = city1;
//         this.city2 = city2;
//         this.cost = cost;
//     }
//   }
//
//    public List<Connection> lowestCost(List<Connection> connections) {
//        // Write your code here
//        List<Connection> result = new ArrayList<>();
//        if(connections == null || connections.size() == 0) {
//            return result;
//        }
//        Map<String, List<Connection>> graph = constructGraph(connections);
//        Set<String> visited = new HashSet<>();
//        // maxHeap
//        Queue<Connection> edges = new PriorityQueue<Connection>((Connection a, Connection b) -> {
//            if(edgeVisited(a, visited) && edgeVisited(b,visited)) return 0;
//            if(edgeVisited(a, visited)) return -1;
//            if(edgeVisited(b, visited)) return 1;
//            return a.cost - b.cost;
//        });
//
//        String startCity = connections.get(0).city1;
//        for(Connection c: graph.get(startCity)) {
//            edges.offer(c);
//        }
//        visited.add(startCity);
//
//
//        while(!edges.isEmpty() && visited.size() != graph.keySet().size()) {
//            Connection min = edges.poll();
//            String city1 = min.city1;
//            String city2 = min.city2;
//            String unvisited = "";
//            if(!visited.contains(city1)) {
//                unvisited = city1;
//                visited.add(city1);
//            }
//            if(!visited.contains(city2)) {
//                unvisited = city2;
//                visited.add(city2);
//            }
//            if(visited.contains(city1) && visited.contains(city2)) {
//                continue;
//            }
//            for(Connection c: graph.get(unvisited)) {
//                edges.offer(c);
//            }
//        }
//
//    }
//
//
//    private boolean edgeVisited(Connection a, Set<String> visited) {
//        if(visited.contains(a.city1) && visited.contains(a.city2)) {
//            return true;
//        }
//        return false;
//    }
//
//    private Map<String, List<Connection>> constructGraph(List<Connection> connections) {
//        Map<String, List<Connection>> graph = new HashMap<>();
//        for(Connection c: connections) {
//            if(!graph.containsKey(c.city1)) {
//                graph.put(c.city1, new ArrayList<>());
//            }
//            if(!graph.containsKey(c.city2)) {
//                graph.put(c.city2, new ArrayList<>());
//            }
//            List<Connection> city1 = graph.get(c.city1);
//            List<Connection> city2 = graph.get(c.city2);
//            city1.add(c);
//            city2.add(c);
//        }
//        return graph;
//    }
}
