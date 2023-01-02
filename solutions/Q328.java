public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode oddhead = head;
        ListNode odd = oddhead;
        ListNode evenhead = head.next;
        ListNode even = evenhead;
        boolean iseven = false;
        head = head.next.next;
        while(head != null){
            if (iseven){
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            iseven = !iseven;
        }
        odd.next = evenhead;
        even.next = null;
        return oddhead;
    }
}
