
import java.util.*;

class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (!st.isEmpty()) {
                        st.pop();
                    } else {
                        count++;
                    }
                    i++;
                } else {
                    if (!st.isEmpty()) {
                        st.pop();
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
        }

        return count + st.size() * 2;
    }
}

