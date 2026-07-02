class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        quickSelect(costs, 0, costs.length - 1, n - 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += costs[i][0];
            ans += costs[i + n][1];
        }
        return ans;
    }

    private void quickSelect(int[][] costs, int le, int r, int n) {
        int pivotInd = pivot(costs, le, r);
        if (pivotInd > n) {
            quickSelect(costs, le, pivotInd - 1, n);
        } else if (pivotInd < n) {
            quickSelect(costs, pivotInd + 1, r, n);
        }
    }

    private int pivot(int[][] costs, int le, int r) {
        int pivotInd = le;
        int pivotDiff = costs[le][0] - costs[le][1];
        int[] pivotCell = costs[le];
        int j = le + 1;
        while (j <= r) {
            if (costs[j][0] - costs[j][1] <= pivotDiff) {
                costs[pivotInd] = costs[j];
                pivotInd++;
                costs[j] = costs[pivotInd];
                costs[pivotInd] = pivotCell;
            }
            j++;
        }
        return pivotInd;
    }}