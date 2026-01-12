class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;   // total subarrays
        long length = 0;  // length of current zero block

        for (int num : nums) {
            if (num == 0) {
                length++;       // extend current zero block
                count += length; // add contribution
            } else {
                length = 0;     // reset when non-zero appears
            }
        }

        return count;
    }
}
