class Solution {
    public long countSubarrays(int[] a, int x, int y) {
        long c = 0;
        int lb = -1;
        int lx = -1;
        int ly = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < x || a[i] > y) lb = i;
            if (a[i] == x) lx = i;
            if (a[i] == y) ly = i;
            c += Math.max(0, Math.min(lx, ly) - lb);
        }

        return c;
    }
}