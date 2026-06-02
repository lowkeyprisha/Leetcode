class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int lf = cal(lst, ld, wst, wd);
        int wf = cal(wst, wd, lst, ld);
        return Math.min(lf, wf);
    }
    
    private int cal(int[] s1, int[] d1, int[] s2, int[] d2) {
        int mmin = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length; i++) {
            mmin = Math.min(mmin, s1[i] + d1[i]);
        }
        
        int mmax = Integer.MAX_VALUE;
        for (int j = 0; j < s2.length; j++) {
            int ast = Math.max(mmin, s2[j]);
            int ft = ast + d2[j];
            mmax = Math.min(mmax, ft);
        }
        
        return mmax;
    }
}