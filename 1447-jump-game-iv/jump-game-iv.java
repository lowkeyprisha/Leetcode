import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int k = 0; k < size; k++) {
                int i = queue.poll();

                if (i + 1 < n && !visited[i + 1]) {
                    if (i + 1 == n - 1) return steps;
                    visited[i + 1] = true;
                    queue.offer(i + 1);
                }

                if (i - 1 >= 0 && !visited[i - 1]) {
                    if (i - 1 == n - 1) return steps;
                    visited[i - 1] = true;
                    queue.offer(i - 1);
                }

                List<Integer> sameVal = graph.get(arr[i]);
                if (sameVal != null) {
                    for (int j : sameVal) {
                        if (!visited[j]) {
                            if (j == n - 1) return steps;
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    graph.remove(arr[i]);
                }
            }
        }

        return -1;
    }
}