import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double distA = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            double distB = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
            return Double.compare(distA, distB);
        });

        for (int[] num : points) {
            pq.add(num);
        }

        int[][] arr = new int[k][2];
        int i = 0;

        while (i < k) {
            arr[i] = pq.poll();
            i++;
        }

        return arr;
    }
}