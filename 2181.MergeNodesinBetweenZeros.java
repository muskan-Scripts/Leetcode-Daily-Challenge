/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head==null)return head;

        ListNode newNode=new ListNode(0);
        ListNode tempnn= newNode;

        ListNode temp= head;
        int currsum=0;
        while(temp!=null){
            if(temp.val==0){
                ListNode ne= new ListNode(currsum);
                tempnn.next=ne;
                currsum=0;
                tempnn=tempnn.next;
            }
            else{
                currsum=currsum+temp.val;
            }
            temp=temp.next;

        }

        return newNode.next.next;
    }
}
