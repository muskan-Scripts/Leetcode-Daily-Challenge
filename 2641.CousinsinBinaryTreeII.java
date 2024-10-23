/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void helper(TreeNode root, List<Integer> li, int sv, int lev) {
        if (root == null)
            return;
        root.val = li.get(lev) - sv - root.val;

        int lv = 0;
        int rv = 0;
        if (root.left != null)
            lv = root.left.val;
        if (root.right != null)
            rv = root.right.val;

        helper(root.left, li, rv, lev+1);
        helper(root.right, li, lv, lev+1);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> li = new LinkedList<>();
        if (root != null)
            q.offer(root);
        while (!q.isEmpty()) {
            int s = q.size();
            int sum = 0;
            for (int i = 0; i < s; i++) {
                TreeNode curr = q.poll();

                sum += curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            li.add(sum);
        }
        helper(root, li, 0, 0);
        return root;

    }
}
