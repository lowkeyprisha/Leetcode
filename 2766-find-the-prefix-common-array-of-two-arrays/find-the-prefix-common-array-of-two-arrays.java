import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            for (int j = 0; j <= i; j++) {
                setA.add(A[j]);
                setB.add(B[j]);
            }

            int count = 0;

            for (int num : setA) {
                if (setB.contains(num)) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}