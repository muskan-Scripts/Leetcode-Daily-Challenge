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
    List<Integer> li= new ArrayList();
    private void makearr(TreeNode root){

        if(root==null)return;
        makearr(root.left);
        li.add(root.val);
        makearr(root.right);

    }

    private TreeNode buildTree(int st, int end){
        if(st>end)return null;
        if(st==end){
            TreeNode newnode = new TreeNode( li.get(st));
            return newnode;
        }
        int mid= st-((st/2)-(end/2));
        TreeNode root= new TreeNode(li.get(mid));

       root.left= buildTree(st, mid-1);
       root.right= buildTree(mid+1, end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        makearr(root);
        return buildTree(0, li.size()-1);
    }
}
