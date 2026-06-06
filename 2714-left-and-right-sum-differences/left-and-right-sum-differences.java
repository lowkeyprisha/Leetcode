import java.util.*;
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] arr = new int[nums.length];
        int lsum=0;
        int rsum=0;
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=i-1;
            while(j<nums.length){
                rsum+=nums[j];
                j++;
            }
            while(k>=0){
                lsum+=nums[k];
                k--;
            }
            arr[i]=Math.abs(lsum-rsum);
            lsum=0;
            rsum=0;
        }
        return arr;
    }
}