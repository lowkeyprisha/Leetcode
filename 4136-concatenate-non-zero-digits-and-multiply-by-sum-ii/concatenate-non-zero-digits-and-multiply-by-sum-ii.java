class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MX = 100_001;
    private static final long[] POW10 = new long[MX];

    static {
        POW10[0] = 1;
        for (int i = 1; i < MX; i++) {
            POW10[i] = (POW10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n + 1];
        int[] prefixNonZero = new int[n + 1];
        long[] prefixValue = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            int d = s.charAt(i - 1) - '0';
            prefixSum[i] = prefixSum[i - 1] + d;
            prefixNonZero[i] = prefixNonZero[i - 1] + (d > 0 ? 1 : 0);
            prefixValue[i] = (d > 0) ? (prefixValue[i - 1] * 10 + d) % MOD : prefixValue[i - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int nonZeroCount = prefixNonZero[r + 1] - prefixNonZero[l];
            int digitSum = prefixSum[r + 1] - prefixSum[l];

            long x = (prefixValue[r + 1] - (prefixValue[l] * POW10[nonZeroCount]) % MOD + MOD) % MOD;
            ans[i] = (int) (x * digitSum % MOD);
        }
        return ans;
    }
}