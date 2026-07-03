/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private String smallestString = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallestString;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        path.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            String currentString = path.reverse().toString();
            path.reverse(); 

            if (currentString.compareTo(smallestString) < 0) {
                smallestString = currentString;
            }
        }

        dfs(node.left, path);
        dfs(node.right, path);

        path.deleteCharAt(path.length() - 1);
    }
}