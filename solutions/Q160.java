public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itr1 = headA;
        ListNode itr2 = headB;

        while (itr1 != itr2){
            if (itr1 == null){
                itr1 = headB;
            } else {
                itr1 = itr1.next;
            }
            if (itr2 == null){
                itr2 = headA;
            } else {
                itr2 = itr2.next;
            }
        }

        return itr1;
    }
}
