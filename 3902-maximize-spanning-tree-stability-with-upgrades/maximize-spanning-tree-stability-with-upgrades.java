class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int high = 0;
        for (int[] e : edges) {
            high = Math.max(high, e[2] * 2);
        }

        int low = 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (can(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean can(int n, int[][] edges, int k, int target) {
        DSU dsu = new DSU(n);
        int need = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) {
                if (s < target) return false;
                if (!dsu.union(u, v)) return false;
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0 && s >= target) {
                dsu.union(u, v);
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0 && s < target && s * 2 >= target) {
                if (dsu.union(u, v)) {
                    need++;
                    if (need > k) return false;
                }
            }
        }

        int root = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) return false;
        }
        return true;
    }

    static class DSU {
        int[] p, r;

        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (r[pa] < r[pb]) {
                p[pa] = pb;
            } else if (r[pa] > r[pb]) {
                p[pb] = pa;
            } else {
                p[pb] = pa;
                r[pa]++;
            }
            return true;
        }
    }
}