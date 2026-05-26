class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0;
        int t = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                f = f + 1;
            }
            if (bills[i] == 10) {
                if (f <= 0) {
                    return false;
                }
                f = f - 1;
                t = t + 1;
            }
            if (bills[i] == 20) {
                if (t > 0 && f > 0) {
                    t = t - 1;
                    f = f - 1;
                } else if (f >= 3) {
                    f = f - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}