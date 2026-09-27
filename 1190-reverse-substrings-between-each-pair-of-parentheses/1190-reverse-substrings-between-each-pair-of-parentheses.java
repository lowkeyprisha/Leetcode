class Solution {
    int i=0;
    public String reverseParentheses(String s) {
        return solve(s);
    }
    String solve(String s){
        StringBuilder ans = new StringBuilder();
        while(i<s.length() && s.charAt(i)!=')'){
            if(s.charAt(i)=='('){
                i++;
                String temp=solve(s);
                ans.append(new StringBuilder(temp).reverse());
                i++;
            }
            else{
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}