public class Q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        if (list1==null){
            return list2;
        } else if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        } else if (list2 == null) {
            current.next = list1;
        }
        return head;
    }
}
