import java.util.*;

class Solution {
    public int getMinDistance(int[] arr, int target, int start) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                int d = Math.abs(i - start);
                if (d < res) {
                    res = d;
                }
            }
        }

        return res;
    }
}