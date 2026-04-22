import java.util.*;

class Solution {
    public int maxDistance(int[] arr) {
        int n = arr.length;
        int a = 0;
        int b = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != arr[0]) {
                a = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != arr[n - 1]) {
                b = n - 1 - i;
                break;
            }
        }

        return Math.max(a, b);
    }
}