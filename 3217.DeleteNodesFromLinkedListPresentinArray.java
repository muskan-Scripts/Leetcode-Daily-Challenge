
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> li = new HashSet<>();
        for(int c:nums){
            li.add(c);

        }

        ListNode ptr=new ListNode(-1);
        ptr.next=head;
        ListNode temp=ptr;
        while(temp!=null && temp.next!=null){
            if(li.contains(temp.next.val)){
                temp.next=temp.next.next;

            }
           
           else{
                temp=temp.next;}
            
        }
        
        return ptr.next;
    }
}
