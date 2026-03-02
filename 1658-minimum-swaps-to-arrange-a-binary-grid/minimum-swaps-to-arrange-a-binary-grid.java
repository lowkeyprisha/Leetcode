class Solution {
    public int minSwaps(int[][] a) {
        int b = a.length;
        int[] c = new int[b];

        for (int d = 0; d < b; d++) {
            int e = -1;
            for (int f = 0; f < b; f++) {
                if (a[d][f] == 1) e = f;
            }
            c[d] = e;
        }

        int g = 0;

        for (int h = 0; h < b; h++) {
            int i = h;
            int j = h;

            while (j < b && c[j] > i) j++;
            if (j == b) return -1;

            while (j > h) {
                int k = c[j];
                c[j] = c[j - 1];
                c[j - 1] = k;
                j--;
                g++;
            }
        }
        return g;
    }
}