class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] l = new boolean[26];
        boolean[] u = new boolean[26];
        boolean[] invalid = new boolean[26];
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                l[idx] = true;
                if (u[idx]) {
                    invalid[idx] = true;
                }
            } else {
                int idx = ch - 'A';
                u[idx] = true;
            }
        }
        
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (l[i] && u[i] && !invalid[i]) {
                count++;
            }
        }
        
        return count;
    }
}