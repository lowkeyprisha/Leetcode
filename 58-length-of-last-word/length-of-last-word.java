class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int l=s.lastIndexOf(" ");
        int len = s.length();
        int c=0;
        for(int i=l+1;i<len;i++){
            c++;
        }
        return c;
        
    }
}