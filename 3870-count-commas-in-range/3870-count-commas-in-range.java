class Solution {
    public int countCommas(int n) {
        int ans=0;
        if(n>999){
            ans=(n-1000)+1;
        }
        else{
            ans=0;
        }
        return ans;
    }
}