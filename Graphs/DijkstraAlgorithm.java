import java.util.*;

public class DijkstraAlgorithm {

    record Node(int vertex, int weight) {
    }

    record Pair(int distance, int vertex) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentDist = current.distance();
            int u = current.vertex();

            if (currentDist > dist[u]) {
                continue;
            }

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex();
                int weight = neighbor.weight();

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(dist[v], v));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        int source = 0;

        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 1);
        addEdge(adj, 1, 0, 4);
        addEdge(adj, 1, 3, 3);
        addEdge(adj, 1, 4, 8);
        addEdge(adj, 2, 0, 1);
        addEdge(adj, 2, 3, 2);
        addEdge(adj, 3, 1, 3);
        addEdge(adj, 3, 2, 2);
        addEdge(adj, 3, 5, 5);
        addEdge(adj, 4, 1, 8);
        addEdge(adj, 4, 5, 1);
        addEdge(adj, 5, 3, 5);
        addEdge(adj, 5, 4, 1);

        int[] shortestDistances = dijkstra(V, adj, source);

        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To vertex " + i + ": "
                    + (shortestDistances[i] == Integer.MAX_VALUE ? "Infinity" : shortestDistances[i]));
        }
    }

    public static void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
    }
}