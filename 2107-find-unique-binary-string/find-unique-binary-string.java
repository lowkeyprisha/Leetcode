class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] res = new char[n];

        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0') {
                res[i] = '1';
            } else {
                res[i] = '0';
            }
        }

        return new String(res);
    }
}