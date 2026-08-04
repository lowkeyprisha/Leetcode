import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        List<Integer> ls = new ArrayList<>();

        for (int i = min + 1; i < max; i++) {
            int target = i;

            if (Arrays.stream(nums).anyMatch(x -> x == target)) {
                continue;
            } else {
                ls.add(i);
            }
        }

        return ls;
    }
}