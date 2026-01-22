import java.util.*;

public class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        int ops = 0;
        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    minIdx = i;
                }
            }
            list.set(minIdx, minSum);
            list.remove(minIdx + 1);
            ops++;
        }
        return ops;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumPairRemoval(new int[]{3, 1, 2}));
    }
}

