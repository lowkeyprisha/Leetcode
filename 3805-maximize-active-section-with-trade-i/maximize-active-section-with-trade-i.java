class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> zeroGroups = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    int last = zeroGroups.size() - 1;
                    zeroGroups.set(last, zeroGroups.get(last) + 1);
                } else {
                    zeroGroups.add(1);
                }
            }
        }

        int best = 0;

        for (int i = 0; i < zeroGroups.size() - 1; i++) {
            best = Math.max(best, zeroGroups.get(i) + zeroGroups.get(i + 1));
        }

        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        return ones + best;
    }
}