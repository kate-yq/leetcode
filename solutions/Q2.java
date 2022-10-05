public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        current.val = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            current.next = new ListNode();
            current = current.next;
            current.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            current.next = new ListNode();
            current = current.next;
            current.val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            current.next = new ListNode();
            current = current.next;
            current.val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }
        if (carry == 1) {
            current.next = new ListNode();
            current = current.next;
            current.val = 1;
        }

        return result;
    }
}
