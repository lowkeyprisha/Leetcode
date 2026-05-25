import java.util.*;
class Solution {
    public int scoreOfString(String s) {
        int s0 = 0;
        for(int i = 0; i < s.length() - 1; i++){
            s0 += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return s0;
    }
}