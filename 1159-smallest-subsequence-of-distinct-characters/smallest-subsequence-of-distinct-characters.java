class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (seen[idx]) continue;

            while (stack.length() > 0) {
                char top = stack.charAt(stack.length() - 1);
                int topIdx = top - 'a';

                if (top > ch && last[topIdx] > i) {
                    seen[topIdx] = false;
                    stack.deleteCharAt(stack.length() - 1);
                } else {
                    break;
                }
            }

            stack.append(ch);
            seen[idx] = true;
        }

        return stack.toString();
    }
}