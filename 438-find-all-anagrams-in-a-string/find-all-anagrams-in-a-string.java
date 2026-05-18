import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {

            windowCount[s.charAt(i) - 'a']++;

            if (i >= windowSize) {
                windowCount[s.charAt(i - windowSize) - 'a']--;
            }

            if (Arrays.equals(pCount, windowCount)) {
                ans.add(i - windowSize + 1);
            }
        }

        return ans;
    }
}