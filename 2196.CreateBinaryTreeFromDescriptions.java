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
import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            int isLeft = description[2];
            
            TreeNode parent = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            nodeMap.put(parentVal, parent);
            nodeMap.put(childVal, child);
            children.add(childVal);
        }
        
        // The root is the node that is never a child.
        int rootVal = -1;
        for (int val : nodeMap.keySet()) {
            if (!children.contains(val)) {
                rootVal = val;
                break;
            }
        }
        
        return nodeMap.get(rootVal);
    }
}
