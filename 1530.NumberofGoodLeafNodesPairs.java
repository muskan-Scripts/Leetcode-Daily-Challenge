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
    int res;
    public int countPairs(TreeNode root, int distance) {
       this.res=0;
        helper(root, distance);
       return this.res;

    }

    private List<Integer> helper(TreeNode root, int distance){
        List<Integer> li= new ArrayList();
        if(root==null){
            return li;
        }
        List<Integer> lef= helper(root.left, distance);
        List<Integer> rig= helper(root.right, distance);

        for(int i=0; i<lef.size(); i++){
            for(int j=0; j<rig.size(); j++){
                if(lef.get(i)+rig.get(j)<=distance){
                    this.res= this.res+1;
                }
            }
        }

        if(root.left==null && root.right==null){
            li.add(1);
            return li;
        }

        for(Integer k: lef){
            li.add(k);
        }
        for(Integer l: rig){
            li.add(l);
        }
        for(int i=0; i<li.size(); i++){
            int t= li.get(i);
            li.set(i, t+1);
        }
        return li;
    }
}
