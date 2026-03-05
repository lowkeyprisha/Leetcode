class Solution {
    public int binaryGap(int n) {
        int a = 0;
        int b = 0;
        boolean c = false;

        while (n > 0) {
            if (n % 2 == 1) {
                if (c) {
                    a = Math.max(a, b);
                }
                c = true;
                b = 1;
            } else {
                if (c) {
                    b++;
                }
            }
            n = n / 2;
        }

        return a;
    }
}
