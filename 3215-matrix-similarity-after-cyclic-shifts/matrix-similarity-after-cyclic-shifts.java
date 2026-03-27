class Solution {
    public boolean areSimilar(int[][] a, int b) {
        int c = a.length;
        int d = a[0].length;
        b %= d;

        for (int e = 0; e < c; e++) {
            for (int f = 0; f < d; f++) {
                int g;
                if (e % 2 == 0) {
                    g = (f + b) % d;
                } else {
                    g = (f - b + d) % d;
                }
                if (a[e][f] != a[e][g]) {
                    return false;
                }
            }
        }
        return true;
    }
}