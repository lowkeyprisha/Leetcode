public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int t = 0;
        int c = 0;
        int s = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            t += diff;
            c += diff;
            
            if (c < 0) {
                c = 0;
                s = i + 1;
            }
        }
        
        return t >= 0 ? s : -1;
    }
}