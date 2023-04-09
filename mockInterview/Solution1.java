public class Solution1 {
    
    public ListNode deteleDuplicate(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        while(cur != null){
            if (cur.val == prev.val){
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
