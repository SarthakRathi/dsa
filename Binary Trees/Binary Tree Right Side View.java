import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int level = 0;
        helper(root, level, ans);
        return ans;
    }

    public void helper(TreeNode root, int level, List<Integer> ans) {
        if (root == null)
            return;
        if (level == ans.size()) {
            ans.add(root.val);
        }
        helper(root.right, level + 1, ans);
        helper(root.left, level + 1, ans);
    }
}