class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        dfs(root, pq);

        while (--k > 0) {
            pq.poll();
        }

        return pq.peek();
    }

    private void dfs(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) return;

        pq.offer(root.val);

        dfs(root.left, pq);
        dfs(root.right, pq);
    }
}