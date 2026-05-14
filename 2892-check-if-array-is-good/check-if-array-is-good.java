import java.util.HashMap;

class Solution {
    public boolean isGood(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        if (nums.length != max + 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.getOrDefault(max, 0) != 2) {
            return false;
        }

        for (int i = 1; i < max; i++) {
            if (map.getOrDefault(i, 0) != 1) {
                return false;
            }
        }

        return true;
    }
}