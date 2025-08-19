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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        max = Math.max(max, l + r);

        return 1 + Math.max(l, r);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)