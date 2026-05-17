import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        if (seen.contains(n)) {
            return false;
        }

        seen.add(n);

        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return isHappy(sum);
    }
}