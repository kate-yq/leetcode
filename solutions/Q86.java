public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(-1);
        ListNode dummyMore = new ListNode(-1);

        ListNode itr1 = dummyLess;
        ListNode itr2 = dummyMore;

        ListNode itr = head;

        while(itr != null){
            if (itr.val < x){
                itr1.next = itr;
                itr = itr.next;
                itr1 = itr1.next;
            } else {
                itr2.next = itr;
                itr = itr.next;
                itr2 = itr2.next;
            }
        }

        itr1.next = dummyMore.next;
        itr2.next = null;

        return dummyLess.next;
    }
}
