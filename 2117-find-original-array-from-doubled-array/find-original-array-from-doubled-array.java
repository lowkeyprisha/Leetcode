class Solution {
    public int[] findOriginalArray(int[] nums) {
        int[] vacarr = new int[0];

        int n = nums.length;

        if (n % 2 != 0) {
            return vacarr;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] ans = new int[nums.length / 2];

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int temp = 0;

        Arrays.sort(nums);

        for (int i : nums) {

            if (hm.get(i) <= 0) {
                continue;
            }

            if (hm.getOrDefault(2 * i, 0) <= 0) {
                return vacarr;
            }

            ans[temp++] = i;

            hm.put(i, hm.get(i) - 1);
            hm.put(2 * i, hm.get(2 * i) - 1);
        }

        return ans;
    }
}