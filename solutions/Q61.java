public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode cur = head;
        int len = 1;
        while(cur.next != null){
            cur = cur.next;
            len++;
        }
        k = k % len;
        if (k == 0){
            return head;
        }
        ListNode fast = head;
        for (int i=0; i<k; i++){
            fast = fast.next;
        }
        ListNode slow = head;
        for (int i=k; i<len-1; i++){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        fast.next = head;
        return newhead;
    }
}
