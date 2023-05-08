public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode tail = head;
        ListNode newHead = head;
        for (int i=0; i<k; i++){
            if (tail == null){
                return head;
            }
            tail = tail.next;
        }
        newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail){
        if (head.next == tail){
            return head;
        }
        ListNode newHead = reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
