public class Q2816 {
    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }

        head = doubleHelper(head);

        if (head.val >= 10) {
            ListNode newHead = new ListNode(head.val / 10, head);
            head.val %= 10;
            return newHead;
        }

        return head;

    }

    private ListNode doubleHelper(ListNode cur) {
        if (cur == null) {
            return null;
        }
        int ans = cur.val * 2;

        ListNode next = doubleHelper(cur.next);
        if (next != null && next.val >= 10) {
            ans += (next.val / 10);
            next.val %= 10;
        }

        cur.val = ans;
        cur.next = next;
        return cur;
    }
}
