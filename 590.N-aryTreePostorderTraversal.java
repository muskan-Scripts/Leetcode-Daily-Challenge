/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private void helper(Node root, List<Integer> li){
        if(root==null)return;
        for(Node f1: root.children){
            helper(f1, li);
        }
        li.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> li= new ArrayList();

        helper(root, li);
        return li;
    }
}
