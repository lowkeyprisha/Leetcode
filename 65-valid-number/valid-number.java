public class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        String t = s.trim();
        if (t.length() == 0) return false;
        return t.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))([eE][+-]?\\d+)?");
    }
}
