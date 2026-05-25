import java.util.HashMap;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Boolean> jewelMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < jewels.length(); i++) {
            jewelMap.put(jewels.charAt(i), true);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (jewelMap.containsKey(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}