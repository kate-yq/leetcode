import java.util.Random;

public class Q382 {
    ListNode head;
    Random rand = new Random();

    public Q382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int ans = 0;
        int i = 1;
        ListNode itr = head;

        while (itr != null) {
            if (rand.nextInt(i) == 0) {
                ans = itr.val;
            }
            itr = itr.next;
            i++;
        }
        return ans;
    }

}
