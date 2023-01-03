public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode newhead = head;
        ListNode tail = null;
        int count = 0;
        while (newhead!= null && count<k){
            tail = newhead;
            newhead = newhead.next;
            count++;
        }

        // remaining not enough for k
        if (count<k){
            return head;
        }
        // remaining enough for k
        tail.next = null;
        ListNode temp = reverseKGroup(newhead, k);
        ListNode ans = reverse(head, k, temp);
        return ans;
    }

    private ListNode reverse(ListNode head, int k, ListNode tail){
        ListNode prev = head;
        ListNode cur = null;
        ListNode next = tail;
        while(prev != null){
            cur = prev;
            prev = prev.next;
            cur.next = next;
            next = cur;
        }
        return cur;
    }
}
