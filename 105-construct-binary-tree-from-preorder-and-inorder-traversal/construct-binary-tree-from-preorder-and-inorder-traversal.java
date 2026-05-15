import java.util.HashMap;

class Solution {

    int a = 0;
    HashMap<Integer, Integer> b = new HashMap<>();

    public TreeNode buildTree(int[] c, int[] d) {

        for (int i = 0; i < d.length; i++) {
            b.put(d[i], i);
        }

        return build(c, 0, d.length - 1);
    }

    public TreeNode build(int[] c, int l, int r) {

        if (l > r) {
            return null;
        }

        int x = c[a++];
        TreeNode y = new TreeNode(x);

        int z = b.get(x);

        y.left = build(c, l, z - 1);
        y.right = build(c, z + 1, r);

        return y;
    }
}