import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int LOG = 17; // 2^17 > 1e5

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[][] parent = new int[LOG][n + 1];
        for (int[] row : parent) Arrays.fill(row, -1);
        int[] depth = new int[n + 1];

        dfs(1, -1, graph, parent, depth);

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                int p = parent[k - 1][v];
                if (p != -1) parent[k][v] = parent[k - 1][p];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int a = lca(u, v, parent, depth);
            int d = depth[u] + depth[v] - 2 * depth[a];
            ans[i] = modPow(2, d - 1);
        }
        return ans;
    }

    private void dfs(int u, int p, List<Integer>[] graph, int[][] parent, int[] depth) {
        parent[0][u] = p;
        for (int v : graph[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u, graph, parent, depth);
        }
    }

    private int lca(int u, int v, int[][] parent, int[] depth) {
        if (depth[u] < depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            int pu = parent[k][u];
            if (pu != -1 && depth[pu] >= depth[v]) {
                u = pu;
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (parent[k][u] != -1 && parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }

    private int modPow(long base, int exp) {
        long result = 1;
        long b = base % MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * b) % MOD;
            b = (b * b) % MOD;
            exp >>= 1;
        }
        return (int) result;
    }
}