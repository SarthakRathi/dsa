import java.util.LinkedList;
import java.util.Queue;

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

class Pair {
    TreeNode a;
    int b;

    Pair(TreeNode a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int cur = queue.peek().b;
                TreeNode node = queue.peek().a;
                queue.poll();
                if (i == 0)
                    first = cur;
                if (i == size - 1)
                    last = cur;
                if (node.left != null)
                    queue.offer(new Pair(node.left, cur * 2 + 1));
                if (node.right != null)
                    queue.offer(new Pair(node.right, cur * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
