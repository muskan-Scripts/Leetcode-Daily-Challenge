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
    private int callen(ListNode head){
        int res=0;
        while(head!=null){
            res++;
            head=head.next;
        }
        return res;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int[] cnt= new int[k];
        int len=callen(head);
        Arrays.fill(cnt, (len/k));
        len=len-((len/k)*k);
        for(int i=0; i<k; i++){
           if(len>0){ cnt[i]++;
            len--;}
        }

        ListNode[] res= new ListNode[k];
        
        for(int i=0; i<k; i++){
            res[i]=head;
            for(int j=0; j<cnt[i]-1; j++){
                head=head.next;
            }
            if(head!=null){ListNode temp=head.next;
            head.next=null;
            head=temp;}
        }

        return res;
    }
}
