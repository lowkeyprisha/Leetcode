class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String x = s.substring(i, j);
                long n = x.chars().filter(c -> c == '1').count();
                if (n == k) {
                    if (ans.equals("") || x.length() < ans.length() ||
                        (x.length() == ans.length() && x.compareTo(ans) < 0)) {
                        ans = x;
                    }
                }
            }
        }
        return ans;
    }
}