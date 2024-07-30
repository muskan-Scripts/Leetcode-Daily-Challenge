/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            if (curNode.left != null) {
                queue.offer(curNode.left);
                if (toDeleteSet.contains(curNode.left.val)) {
                    curNode.left = null;
                }
            }

            if (curNode.right != null) {
                queue.offer(curNode.right);
                if (toDeleteSet.contains(curNode.right.val)) {
                    curNode.right = null;
                }
            }

            if (toDeleteSet.contains(curNode.val)) {
                if (curNode.left != null) {
                    result.add(curNode.left);
                }
                if (curNode.right != null) {
                    result.add(curNode.right);
                }
            } else if (result.isEmpty()) {
                result.add(curNode);
            }
        }

        return result;
    }
}
