public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // use help function
        if (nums1.length>nums2.length){
            return _findMedian(nums2, nums2.length, nums1, nums1.length);
        } else {
            return _findMedian(nums1, nums1.length, nums2, nums2.length);
        }
    }

    private double _findMedian(int[] a, int a_len, int[] b, int b_len){
        // a is always shorter
        int half = (a_len + b_len) / 2;
        int left = 0;
        int right = a_len - 1;
        while (true) {
            
            int medium = (left + right) / 2;
            double a_left, a_right, b_left, b_right;
            // corner case: nums1==null
            if (a_len == 0){
                a_left = Integer.MIN_VALUE;
                a_right = Integer.MAX_VALUE;
                medium = -1;
            } else {
                if (medium >= 0 && medium<a_len) {
                    a_left = a[medium];
                } else {
                    a_left = Integer.MIN_VALUE;
                }
                if (medium + 1 < a_len) {
                    a_right = a[medium + 1];
                } else {
                    a_right = Integer.MAX_VALUE;
                }
            }

            if (half - medium - 2 < 0) {
                b_left = Integer.MIN_VALUE;
            } else {
                b_left = b[half - medium - 2];
            }
            if (half - medium - 1 < b_len) {
                b_right = b[half - medium - 1];
            } else {
                b_right = Integer.MAX_VALUE;
            }

            // the medium in nums1 is larger than min.right of nums2
            // left shift medium
            // the medium+1 in nums1 is smaller than max.left of nums2
            // right shift medium
            if (a_left > b_right) {
                right = medium - 1;
                if (right == -1){
                    right--;
                }
            } else if (b_left > a_right) {
                left = medium + 1;
            } else {
                if ((a_len + b_len) % 2 == 1) {
                    // odd
                    return Math.min(a_right, b_right);
                } else {
                    // even
                    return (Math.max(a_left, b_left) + Math.min(a_right, b_right)) / 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test_case_1a = {1,2,3,4};
        int[] test_case_1b = {5,6,7,8};
        int[] test_case_2a = { 1, 1, 4, 4, 5 };
        int[] test_case_2b = {};
        int[] test_case_3a = {1,3};
        int[] test_case_3b = {2};
        Q4 fM = new Q4();
        System.out.println("exp 4.5: " + fM.findMedianSortedArrays(test_case_1a, test_case_1b));
        System.out.println("exp 4: " + fM.findMedianSortedArrays(test_case_2a, test_case_2b));
        System.out.println("exp 2: " + fM.findMedianSortedArrays(test_case_3a, test_case_3b));
    }
}
