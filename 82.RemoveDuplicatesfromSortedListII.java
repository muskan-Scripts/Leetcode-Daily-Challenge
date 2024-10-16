class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle the edge case where the head is part of the duplicates
        ListNode ortemp = new ListNode(-1);
        ortemp.next = head;
        ListNode temp = ortemp;

        while (temp.next != null) {
            ListNode st = temp.next;
            ListNode en = st.next;

            // Check if there are any duplicates for the current node (st.val)
            while (en != null && st.val == en.val) {
                en = en.next;
            }

            // If st has no duplicates, move temp forward
            if (st.next == en) {
                temp = temp.next;
            } else {
                // If duplicates exist, skip them by linking temp to en
                temp.next = en;
            }
        }

        return ortemp.next;
    }
}
