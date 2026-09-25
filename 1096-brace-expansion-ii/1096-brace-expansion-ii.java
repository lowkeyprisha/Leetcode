class Solution {
    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            if (s.charAt(i) == '{') {
                i++;
                Set<String> inside = solve(s);
                i++;

                current = multiply(current, inside);

            } else if (s.charAt(i) == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;

            } else {
                String ch = "" + s.charAt(i);
                Set<String> letter = new HashSet<>();
                letter.add(ch);

                current = multiply(current, letter);
                i++;
            }
        }

        result.addAll(current);
        return result;
    }

    Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}