class Solution {
    public int longestSubsequence(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[][] dp = new int[max + 1][max + 1];

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            for (int j = 1; j <= max; j++) {
                int diff = Math.abs(curr - j);
                if (dp[curr][diff] < dp[j][diff] + 1) {
                    dp[curr][diff] = dp[j][diff] + 1;
                }
            }

            for (int d = max - 1; d >= 0; d--) {
                if (dp[curr][d] < dp[curr][d + 1]) {
                    dp[curr][d] = dp[curr][d + 1];
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= max; i++) {
            if (dp[i][0] > ans) {
                ans = dp[i][0];
            }
        }

        return ans;
    }
}