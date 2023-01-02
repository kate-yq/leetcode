public class Q876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean slowmove = false;
        while(fast != null){
            fast = fast.next;
            if (slowmove){
                slow = slow.next;
            }
            slowmove = !slowmove;
        }
        return slow;
    }
}
