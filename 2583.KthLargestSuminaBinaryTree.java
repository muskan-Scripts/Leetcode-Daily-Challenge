import java.util.*;

class Solution {
    private void trav(TreeNode root, int k, PriorityQueue<Long> pq) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        
        while (!q.isEmpty()) {
            int s = q.size();
            long sum = 0;
            for (int i = 0; i < s; i++) {
                TreeNode curr = q.poll();
                sum += (long) curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            pq.add(sum);
            // Maintain size of the priority queue to k
            if (pq.size() > k) pq.poll();
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        // Use a min-heap of size k to store the largest k sums
        PriorityQueue<Long> pq = new PriorityQueue<>();
        trav(root, k, pq);

        // If there are fewer than k levels, return -1
        if (pq.size() < k) return -1;

        // The kth largest element will now be at the root of the heap
        return pq.peek();
    }
}
