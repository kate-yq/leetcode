public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        } else if (head.next == null){
            return head;
        }
        ListNode current = head.next;
        ListNode prev = current.next;
        head.next = null;
        current.next = head;
        head = current;
        while (prev != null){
            current = prev;
            prev = prev.next;
            current.next = head;
            head = current;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode test_case_1 = new ListNode();
        test_case_1.val = 1;
        test_case_1.next = new ListNode();
        test_case_1.next.val = 2;
        test_case_1.next.next = new ListNode();
        test_case_1.next.next.val = 3;
        test_case_1.next.next.next = new ListNode();
        test_case_1.next.next.next.val = 4;

        ListNode test_case_2 = new ListNode();

        Q206 rL = new Q206();
        test_case_1 = rL.reverseList(test_case_1);
        while (test_case_1 !=null){
            System.out.print(test_case_1.val+", ");
            test_case_1 = test_case_1.next;
        }
        test_case_2 = rL.reverseList(test_case_2);
        while (test_case_2 !=null){
            System.out.print(test_case_2.val+", ");
            test_case_2 = test_case_2.next;
        }
    }
}
