/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int ans[] = new int[] {Integer.MAX_VALUE, -1 };
     
        int last = head.val;

        int first = -1;
        int lastc = -1;

        int cnt = 1;
        ListNode temp = head.next;
        while (temp.next != null) {
            cnt++;
            if ((temp.val < temp.next.val && temp.val < last) || (temp.val > temp.next.val && temp.val > last)) {
                if (first == -1) {
                    first = cnt;
                }
                if (lastc !=-1) {
                    ans[0] = Math.min(cnt-lastc, ans[0]);
                }
                lastc = cnt;
            }
            last=temp.val;
            temp=temp.next;
          
        }
        if(first!=-1 && lastc!=-1){
            ans[1]=lastc-first;
        }
        if(ans[0]==Integer.MAX_VALUE){
            int as[] = new int[] {-1, -1 };
            return as;}
        return ans;
    }
}
