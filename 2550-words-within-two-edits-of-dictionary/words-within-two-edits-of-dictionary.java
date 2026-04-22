import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();

        for (String a : queries) {
            for (String b : dictionary) {
                int c = 0;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        c++;
                    }
                    if (c > 2) break;
                }

                if (c <= 2) {
                    res.add(a);
                    break;
                }
            }
        }
        return res;
    }
}