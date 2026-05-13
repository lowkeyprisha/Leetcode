class Solution {
    public int mySqrt(int a) {
        long b = 0, c = a;

        while (b <= c) {
            long d = b + (c - b) / 2;
            long e = d * d;

            if (e == a) return (int)d;
            if (e < a) b = d + 1;
            else c = d - 1;
        }

        return (int)c;
    }
}