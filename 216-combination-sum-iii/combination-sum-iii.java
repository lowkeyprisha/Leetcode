import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, new ArrayList<>());
        return result;
    }

    private void backtrack(int k, int n, int start, List<Integer> path) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (k == 0 || n < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(k - 1, n - i, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}