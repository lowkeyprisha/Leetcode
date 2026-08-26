class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0, ones = 0;
        String ans = "";

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '1') ones++;

            while (ones > k) {
                if (s.charAt(l) == '1') ones--;
                l++;
            }

            while (ones == k && s.charAt(l) == '0') {
                l++;
            }

            if (ones == k) {
                String x = s.substring(l, r + 1);

                if (ans.equals("") || x.length() < ans.length() ||
                    (x.length() == ans.length() && x.compareTo(ans) < 0)) {
                    ans = x;
                }
            }
        }

        return ans;
    }
}