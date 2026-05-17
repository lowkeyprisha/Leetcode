import java.util.*;
class Solution {
    public boolean isPowerOfThree(int n) {
        boolean ans=false;
        for(int i=0;i<31;i++){
            if(Math.pow(3,i)==n){
                ans=true;
                break;
            }
            else{
                ans=false;
            }
        }
        return ans;
        
    }
}