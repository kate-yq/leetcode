public class Q287 {
    public int findDuplicate(int[] nums) {
        // see the array as a linked list
        // from index to element
        // when a circle setected
        // the start of the circle is the duplicate num

        // a fast pointer and a slow pointer to detect circle
        int slow = nums[0];
        int fast = nums[0];
        // first run
        fast = nums[nums[fast]];
        slow = nums[slow];
        while (fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        // then slow start over form 0
        // fast continue in circle
        // when they meet, it is the start of the circle
        slow = nums[0];
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
