class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        int a = n / 2;
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < a; i++) {
            sum1 += nums[i];
        }
        for (int i = a; i < n; i++) {
            sum2 += nums[i];
        }
        return sum2 - sum1;
    }
}