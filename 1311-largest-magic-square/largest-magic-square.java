class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // rowPrefix[i][j] = sum of grid[i][0..j-1]  (length n+1)
        int[][] rowPrefix = new int[m][n + 1];
        // colPrefix[i][j] = sum of grid[0..i-1][j]  (length m+1)
        int[][] colPrefix = new int[m + 1][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }
        }

        int maxK = Math.min(m, n);
        // try larger sizes first for early return
        for (int k = maxK; k >= 1; --k) {
            for (int i = 0; i + k <= m; ++i) {
                for (int j = 0; j + k <= n; ++j) {
                    // target sum: first row of the kxk square
                    int target = rowPrefix[i][j + k] - rowPrefix[i][j];

                    boolean ok = true;
                    // check each row sum
                    for (int r = 0; r < k; ++r) {
                        int rowSum = rowPrefix[i + r][j + k] - rowPrefix[i + r][j];
                        if (rowSum != target) { ok = false; break; }
                    }
                    if (!ok) continue;

                    // check each column sum
                    for (int c = 0; c < k; ++c) {
                        int colSum = colPrefix[i + k][j + c] - colPrefix[i][j + c];
                        if (colSum != target) { ok = false; break; }
                    }
                    if (!ok) continue;

                    // check main diagonal
                    int diag1 = 0;
                    for (int d = 0; d < k; ++d) diag1 += grid[i + d][j + d];
                    if (diag1 != target) continue;

                    // check anti-diagonal
                    int diag2 = 0;
                    for (int d = 0; d < k; ++d) diag2 += grid[i + d][j + k - 1 - d];
                    if (diag2 != target) continue;

                    // passed all checks
                    return k;
                }
            }
        }
        // at minimum, 1x1 is always a magic square, so function will return earlier,
        // but keep fallback:
        return 1;
    }
}
