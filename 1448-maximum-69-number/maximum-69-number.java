class Solution {
    public int maximum69Number (int num) {
        // Convert number to string for easy manipulation
        char[] digits = String.valueOf(num).toCharArray();
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9'; // change first 6 to 9
                break;           // only one change allowed
            }
        }
        
        // Convert back to integer
        return Integer.parseInt(new String(digits));
    }
}
