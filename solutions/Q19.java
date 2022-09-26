// **
// Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 1;
        while(current.next!= null){
            count++;
            current = current.next;
        }
        if (count == n){
            head = head.next;
            return head;
        }

        current = head;
        for (int i = count-n-1; i>0; i--){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Q19 remove = new Q19();
        remove.removeNthFromEnd(head, 2);
        ListNode current = head;
        System.out.println(current.val);
        while(current.next!= null){
            current = current.next;
            System.out.println(current.val);
        }
    }
}