class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int l = Math.max(0, maxDepth(root.left));
        int r = Math.max(0, maxDepth(root.right));

        max = Math.max(max, l + r + root.val);

        return root.val + Math.max(l, r);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)