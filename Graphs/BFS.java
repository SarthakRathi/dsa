import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS {
    public static void main(String[] args) {
        int v = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(2).add(5);
        adj.get(4).add(6);

        ArrayList<Integer> bfsResult = bfs(v, adj);

        System.out.println("BFS Traversal starting from node 0:");
        for (Integer node : bfsResult) {
            System.out.print(node + " ");
        }
    }

    public static ArrayList<Integer> bfs(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
}