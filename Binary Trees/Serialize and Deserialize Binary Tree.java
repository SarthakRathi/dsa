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

class Solution {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                ans.append("null,");
                continue;
            }
            ans.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return ans.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            String l = values[idx++];
            if (!l.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(l));
                temp.left = leftNode;
                queue.offer(leftNode);
            }

            String r = values[idx++];
            if (!r.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(r));
                temp.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}