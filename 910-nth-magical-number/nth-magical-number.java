class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long mod = 1_000_000_007L;
        long l = 1;
        long r = (long) n * Math.min(a, b);
        long lcm = (long) a / gcd(a, b) * b;

        while (l < r) {
            long m = l + (r - l) / 2;
            long count = m / a + m / b - m / lcm;
            if (count >= n) r = m;
            else l = m + 1;
        }

        return (int) (l % mod);
    }

    private long gcd(long x, long y) {
        while (y != 0) {
            long t = x % y;
            x = y;
            y = t;
        }
        return x;
    }
}