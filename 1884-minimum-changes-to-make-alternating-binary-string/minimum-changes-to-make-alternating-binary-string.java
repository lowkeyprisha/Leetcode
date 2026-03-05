class Solution {
    public int minOperations(String s) {
        int a = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i % 2 == 0 && s.charAt(i) != '0') ||
                (i % 2 == 1 && s.charAt(i) != '1')) {
                a++;
            }

            if ((i % 2 == 0 && s.charAt(i) != '1') ||
                (i % 2 == 1 && s.charAt(i) != '0')) {
                b++;
            }
        }

        return Math.min(a, b);
    }
}