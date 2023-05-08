public class Q234 {
    // reverse second half and check one by one
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findmid(head);
        ListNode tail = reverse(mid);
        while(head != null && tail != null){
            if (head.val != tail.val){
                reverse(mid);
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        reverse(mid);
        return true;
    }

    private ListNode findmid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = head;
        ListNode cur = null;
        ListNode next = null;
        while(prev != null){
            cur = prev;
            prev = prev.next;
            cur.next = next;
            next = cur;
        }
        return cur;
    }
}
