public class Q141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
            if (fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return false;
    }
}
