import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if (stops > k)
                continue;

            for (Pair iter : adj.get(node)) {
                int dest = iter.first;
                int dis = iter.second;

                if (cost + dis < dist[dest]) {
                    dist[dest] = cost + dis;
                    q.add(new Tuple(stops + 1, dest, cost + dis));
                }
            }
        }

        if (dist[dst] == (int) (1e9))
            return -1;
        return dist[dst];
    }
}