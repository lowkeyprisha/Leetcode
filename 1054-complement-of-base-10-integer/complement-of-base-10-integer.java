class Solution {
    public int bitwiseComplement(int n) {
        String num = Integer.toBinaryString(n);
        String r="";
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)=='0'){
                r=r+'1';
            }
            else{
                r=r+'0';
            }
        }
        return Integer.parseInt(r,2);
    }
}