package Coding;

import java.util.*;

public class MinimumSpanningTreeLintCode {

    public class Connection {
        public String city1, city2;
        public int cost;
        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        Collections.sort(connections, comp);
        Map<String, Integer> hash = new HashMap<>();
        int n = 0;
        for (Connection connection : connections) {
            if (!hash.containsKey(connection.city1)) {
                hash.put(connection.city1, ++n);
            }
            if (!hash.containsKey(connection.city2)) {
                hash.put(connection.city2, ++n);
            }
        }

        int[] father = new int[n + 1];

        List<Connection> results = new ArrayList<>();
        for (Connection connection : connections) {
            int num1 = hash.get(connection.city1);
            int num2 = hash.get(connection.city2);

            int root1 = find(num1, father);
            int root2 = find(num2, father);
            if (root1 != root2) {
                father[root1] = root2;
                results.add(connection);
            }
        }

        if (results.size() != n - 1)
            return new ArrayList<>();
        return results;
    }

    static Comparator<Connection> comp = (Connection a, Connection b) -> {
            if (a.cost != b.cost)
                return a.cost - b.cost;
            if (a.city1.equals(b.city1)) {
                return a.city2.compareTo(b.city2);
            }
            return a.city1.compareTo(b.city1);
    };

    public int find(int num, int[] father) {
        if (father[num] == 0)
            return num;

        return father[num] = find(father[num], father);
    }
}

