import java.util.Arrays;

class Solution {
    private int[] memo;

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        int maxVisited = 0;
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, n, d, i));
        }
        return maxVisited;
    }

    private int dfs(int[] arr, int n, int d, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }
        int maxFromCurrent = 1;
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i]) {
                break;
            }
            maxFromCurrent = Math.max(maxFromCurrent, 1 + dfs(arr, n, d, j));
        }
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[j] >= arr[i]) {
                break;
            }
            maxFromCurrent = Math.max(maxFromCurrent, 1 + dfs(arr, n, d, j));
        }
        return memo[i] = maxFromCurrent;
    }
}