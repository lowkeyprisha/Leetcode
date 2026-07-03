class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] best = new int[26];
        int cur = 0;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                cur++;
            } else {
                cur = 1;
            }
            int idx = p.charAt(i) - 'a';
            best[idx] = Math.max(best[idx], cur);
        }

        int ans = 0;
        for (int x : best) ans += x;
        return ans;
    }
}