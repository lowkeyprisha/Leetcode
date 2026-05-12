import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] s) {

        HashMap<String, List<String>> m = new HashMap<>();

        for (String a : s) {

            char[] b = a.toCharArray();

            Arrays.sort(b);

            String c = "";

            for (char d : b) {
                c += d;
            }

            if (!m.containsKey(c)) {
                m.put(c, new ArrayList<>());
            }

            m.get(c).add(a);
        }

        return new ArrayList<>(m.values());
    }
}