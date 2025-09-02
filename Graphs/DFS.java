import java.util.ArrayList;

class DFS {
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

        ArrayList<Integer> dfsResult = dfs(v, adj);

        System.out.println("DFS Traversal starting from node 0:");
        for (Integer node : dfsResult) {
            System.out.print(node + " ");
        }
    }

    public static ArrayList<Integer> dfs(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) { // For disconnected graph
            if (!vis[i]) {
                dfsHelper(i, vis, adj, dfs);
            }
        }
        return dfs;
    }

    public static void dfsHelper(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        vis[node] = true;
        dfs.add(node);
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfsHelper(it, vis, adj, dfs);
            }
        }
    }
}