import java.util.Stack;

public class Q143 {
    public void reorderList(ListNode head) {
        Stack<ListNode> assist = new Stack<>();
        ListNode current = head;
        while (current.next != null){
            assist.add(current);
            current = current.next;
        }
        assist.add(current);
        current = head;
        int count = assist.size();
        while (count>0){
            ListNode temp = current.next;
            current.next = assist.pop();
            current = current.next;
            count--;
            if (count>0){
                current.next = temp;
                current = current.next;
                count--;
            } else {
                break;
            }
        }
        current.next = null;
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
        test_case_2.val = 1;
        test_case_2.next = new ListNode();
        test_case_2.next.val = 2;
        test_case_2.next.next = new ListNode();
        test_case_2.next.next.val = 3;
        test_case_2.next.next.next = new ListNode();
        test_case_2.next.next.next.val = 4;
        test_case_2.next.next.next.next = new ListNode();
        test_case_2.next.next.next.next.val = 5;

        Q143 reorder = new Q143();
        reorder.reorderList(test_case_1);
        reorder.reorderList(test_case_2);
        while (test_case_1.next!=null){
            System.out.print(test_case_1.val+", ");
            test_case_1 = test_case_1.next;
        }
        System.out.println(test_case_1.val);
        while (test_case_2.next!=null){
            System.out.print(test_case_2.val+", ");
            test_case_2 = test_case_2.next;
        }
        System.out.println(test_case_2.val);
    }
}
