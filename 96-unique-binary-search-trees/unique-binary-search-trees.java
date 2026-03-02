class Solution {
    public int numTrees(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long sum = 0;
            for (int root = 1; root <= i; root++) {
                sum += dp[root - 1] * dp[i - root];
            }
            dp[i] = sum;
        }
        return (int) dp[n];
    }
}