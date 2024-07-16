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
    String Ls="";
    String Lt="";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb=new StringBuilder();
        helper(root, startValue, destValue, sb);
        int i=0;
        for(i=0; i<Math.min(Lt.length(),Ls.length()); i++){
           if(Ls.charAt(i)!=Lt.charAt(i))break;
        }
        StringBuilder ans=new StringBuilder();
        for(int k=i; k<Ls.length(); k++){
            ans.append("U");
        }
        for(int k=i; k<Lt.length(); k++){
            ans.append(Lt.charAt(k));
        }

        return ans.toString();
    }

    private void helper(TreeNode root, int st, int en, StringBuilder sb){
        if(root==null )return;

        if(root.val==st){
            Ls=sb.toString();
            
        }
        if(root.val==en){
            Lt=sb.toString();
           
        }
       sb.append("L");
       helper(root.left, st, en, sb);
       sb.deleteCharAt(sb.length()-1);
       sb.append("R");
       helper(root.right, st, en, sb);
        sb.deleteCharAt(sb.length()-1);
       return;

    }
}
