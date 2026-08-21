import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = 1;
        long right = (long) coins[0] * k;
        
        for (int coin : coins) {
            right = Math.min(right, (long) coin * k);
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    public long count(long n, int[] coins) {
        long result = 0;
        int m = coins.length;

        for (int mask = 1; mask < (1 << m); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    if (lcm > n) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long value = n / lcm;

            if (bits % 2 == 1) {
                result += value;
            } else {
                result -= value;
            }
        }

        return result;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}