class Solution {
    public boolean check(int[] nums) {
        int countDrops = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                countDrops++;
            }
            if (countDrops > 1) {
                return false;
            }
        }
        return true;
    }
}