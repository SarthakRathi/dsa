class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }

    public static void dfs(int[][] isConnected, int node, boolean vis[]) {
        vis[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !vis[i]) {
                dfs(isConnected, i, vis);
            }
        }
    }
}