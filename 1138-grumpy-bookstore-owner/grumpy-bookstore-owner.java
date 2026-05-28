class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int sat = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sat += customers[i];
            }
        }

        int add = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                add += customers[i];
            }
        }

        int max = add;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                add += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                add -= customers[i - minutes];
            }
            max = Math.max(max, add);
        }

        return sat + max;
    }
}