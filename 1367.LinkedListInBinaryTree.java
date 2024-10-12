class Solution {
    private boolean checkPath( TreeNode root,ListNode head){
      if (head == null) return true;
        // If the tree ends or values don't match, return false
        if (root == null || root.val != head.val) return false;
        
        // Check both left and right subtrees for the next part of the linked list
        return checkPath(root.left, head.next) || checkPath(root.right, head.next);
    }
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null )return false;
        boolean res=false;
        if(root.val==head.val){
            res= checkPath(root, head);
        }
        return (res || isSubPath(head, root.left) || isSubPath(head, root.right));
    }
}
