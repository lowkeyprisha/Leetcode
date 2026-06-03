class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(arr, visited, i);
            }
        }
        return provinces;
    }
    
    private void dfs(int[][] arr, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < arr.length; j++) {
            if (arr[i][j] == 1 && !visited[j]) {
                dfs(arr, visited, j);
            }
        }
    }
}