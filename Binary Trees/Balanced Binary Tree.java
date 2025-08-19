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
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = checkHeight(node.left);
        if (l == -1) {
            return -1;
        }

        int r = checkHeight(node.right);
        if (r == -1) {
            return -1;
        }

        if (Math.abs(l - r) > 1) {
            return -1;
        }

        return 1 + Math.max(l, r);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)