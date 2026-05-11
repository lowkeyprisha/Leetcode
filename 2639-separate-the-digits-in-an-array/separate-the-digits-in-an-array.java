class Solution {
    public int[] separateDigits(int[] nums) {
        int td = 0;

        for (int num : nums) {
            if (num == 0) {
                td++;
            } else {
                while (num > 0) {
                    td++;
                    num /= 10;
                }
            }
        }

        int[] res = new int[td];
        int idx = td - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            if (num == 0) {
                res[idx--] = 0;
            } else {
                while (num > 0) {
                    res[idx--] = num % 10;
                    num /= 10;
                }
            }
        }

        return res;
    }
}