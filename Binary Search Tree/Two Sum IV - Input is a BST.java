import java.util.Stack;

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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator forwardIterator = new BSTIterator(root, true);

        BSTIterator backwardIterator = new BSTIterator(root, false);

        int left = forwardIterator.next();
        int right = backwardIterator.next();

        while (left < right) {
            int sum = left + right;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                left = forwardIterator.next();
            } else {
                right = backwardIterator.next();
            }
        }

        return false;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean isForward;

    public BSTIterator(TreeNode root, boolean isForward) {
        this.isForward = isForward;
        pushAll(root);
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        if (isForward) {
            pushAll(tempNode.right);
        } else {
            pushAll(tempNode.left);
        }
        return tempNode.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            if (isForward) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
}