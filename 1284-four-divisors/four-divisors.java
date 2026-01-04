class Solution {
    public int sumFourDivisors(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] div = new int[4];
            int c = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    if (c < 4) {
                        div[c++] = j;
                    } else {      // found a 5th divisor — mark and stop
                        c = 5;
                        break;
                    }
                }
            }
            if (c == 4) {
                int sum = div[0] + div[1] + div[2] + div[3];
                s = s + sum;
            }
        }
        return s;
    }
}

