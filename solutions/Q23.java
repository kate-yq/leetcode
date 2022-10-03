public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int space = 1;
        while (space < lists.length) {
            for (int i = 0; i < lists.length-space; i += space) {
                lists[i] = merge2Lists(lists[i], lists[i + space]);
                i += space;
            }
            space = space * 2;
        }

        return lists[0];
    }

    private ListNode merge2Lists(ListNode a, ListNode b) {
        ListNode head = new ListNode();
        if (a==null){
            return b;
        } else if (b == null){
            return a;
        }
        if (a.val < b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }
        ListNode current = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                current = current.next;
                a = a.next;
            } else {
                current.next = b;
                current = current.next;
                b = b.next;
            }
        }
        if (a == null) {
            current.next = b;
        } else if (b == null) {
            current.next = a;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        ListNode b = new ListNode();
        b.val = 1;
        b.next = new ListNode();
        b.next.val = 4;
        ListNode c = new ListNode();
        c.val = 1;
        c.next = new ListNode();
        c.next.val = 2;
        c.next.next = new ListNode();
        c.next.next.val = 3;
        c.next.next.next = new ListNode();
        c.next.next.next.val = 4;
        c.next.next.next.next = new ListNode();
        c.next.next.next.next.val = 5;
        Q23 mK = new Q23();

        ListNode[] test_case_1 = new ListNode[0];
        ListNode result1 = mK.mergeKLists(test_case_1);
        System.out.println("case 1 (exp empty)");
        while (result1 != null) {
            System.out.print(result1.val + ", ");
            result1 = result1.next;
        }
        System.out.println();

        ListNode[] test_case_2 = new ListNode[1];
        test_case_2[0] = a;
        ListNode result2 = mK.mergeKLists(test_case_2);
        System.out.println("case 2 (exp empty)");
        while (result2 != null) {
            System.out.print(result2.val + ", ");
            result2 = result2.next;
        }
        System.out.println();

        ListNode[] test_case_3 = new ListNode[3];
        test_case_3[0] = a;
        test_case_3[1] = b;
        test_case_3[2] = c;
        ListNode result3 = mK.mergeKLists(test_case_3);
        System.out.println("case 3");
        while (result3 != null) {
            System.out.print(result3.val + ", ");
            result3 = result3.next;
        }
        System.out.println();
    }
}
