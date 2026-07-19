class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;
        int odd = 0;
        for (int f : map.values()) {
            if (f % 2 == 0) {
                sum += f;
            } else {
                sum += f - 1;
                odd++;
            }
        }
        if (odd > 0) {
            sum++;
        }
        return sum;
    }
}