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
    public boolean isValidBST(TreeNode root) {
        return checker(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checker(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (min >= root.val || root.val >= max) {
            return false;
        }
        return checker(root.left, min, root.val) && checker(root.right, root.val, max);
    }
}