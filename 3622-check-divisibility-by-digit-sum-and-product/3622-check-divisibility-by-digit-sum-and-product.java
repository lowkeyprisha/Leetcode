class Solution {
    public boolean checkDivisibility(int n) {
        int prod=1, sum=0;
        int x=n;
        boolean ans=false;
        while(n!=0){
            int a=n%10;
            sum+=a;
            prod*=a;
            n=n/10;
        }
        if(x%(sum+prod)==0){
            ans=true;
        }
        else{
            ans=false;
        }
        return ans;
    }
}