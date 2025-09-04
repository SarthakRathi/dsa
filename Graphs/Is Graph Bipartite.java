class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];

        for (int i = 0; i < visited.length; i++)
            visited[i] = -1;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == -1) {
                if (dfs(i, 0, visited, graph) == false)
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int group, int[] visited, int[][] graph) {
        visited[node] = group;
        for (int i = 0; i < graph[node].length; i++) {
            int temp = graph[node][i];
            if (visited[temp] == -1) {
                if (dfs(temp, 1 - group, visited, graph) == false)
                    return false;
            } else {
                if (visited[temp] == group)
                    return false;
            }
        }
        return true;
    }
}