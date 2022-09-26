public class Q33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // with unroasted array, simple binary search
        // while (nums[left]<nums[right]){
        //     int medium = (right + left) / 2;
        //     if (target < nums[medium]){
        //         right = medium;
        //     } else if (target > nums[medium]){
        //         left = medium+1;
        //     } else {
        //         return medium;
        //     }
        // }

        // target<left >right, return -1
        if (target < nums[left] && target > nums[right]) {
            return -1;
        }

        while (left < right) {
            int medium = (right + left) / 2;
            if (target == nums[medium]) {
                return medium;
            }
            // medium > right
            // target >left < medium, right=medium
            // target >left > medium, left=medium
            // target < rigth < medium, left=medium

            // medium < right
            // target >left > medium, right = medium
            // target <right > medium, left=medium
            // target <right <medium, right =medium

            if (nums[medium] > nums[right]) {
                if (target > nums[left] && target < nums[medium]) {
                    right = medium - 1;
                } else if (target == nums[left]){
                    return left;
                } else {
                    left = medium + 1;
                }
            } else {
                if (target < nums[right] && target > nums[medium]) {
                    left = medium + 1;
                } else if (target == nums[right]){
                    return right;
                } else {
                    right = medium - 1;
                }
            }
        }

        if (target == nums[left]) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test_case = { 1, 3 };
        Q33 search = new Q33();
        System.out.println("exp-1:  " + search.search(test_case, 0));
        System.out.println("exp1:  " + search.search(test_case, 3));
    }
}
