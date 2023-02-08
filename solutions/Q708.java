public class Q708 {
    public ListNode insert(ListNode head, int insertVal) {
        if (head == null){
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while(true){
            if (prev.val<= insertVal && cur.val>= insertVal){
                ListNode ins = new ListNode(insertVal);
                prev.next = ins;
                ins.next = cur;
                break;
            } else if (cur.val < prev.val && (insertVal>=prev.val || insertVal <= cur.val)){
                ListNode ins = new ListNode(insertVal);
                prev.next = ins;
                ins.next = cur;
                break;
            } else if (cur == head) {
                ListNode ins = new ListNode(insertVal);
                prev.next = ins;
                ins.next = cur;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
