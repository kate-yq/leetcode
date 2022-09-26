public class Q152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int temp_1 = 1;
        int temp_2 = 1;

        // the following are referential answer:

        for (int i = 0; i < nums.length; i++) {
            temp_1 = temp_1 * nums[i];
            temp_2 = temp_2 * nums[nums.length - 1 - i];
            if (temp_1 > max) {
                max = temp_1;
            }
            if (temp_2 > max) {
                max = temp_2;
            }

            if (temp_1 == 0) {
                temp_1 = 1;
            }
            if (temp_2 == 0) {
                temp_2 = 1;
            }
        }

        // the following are my original answer

        // boolean include_front = true;
        // for (int i = 0; i < nums.length; i++) {
        // // special case: when [i]==0
        // // reset all and treat the remaining nums as a new array
        // if (nums[i] == 0) {
        // temp_1 = 1;
        // temp_2 = 1;
        // include_front = true;
        // if (max < 0) {
        // max = 0;
        // }
        // continue;
        // }

        // // mark when passing the first negative int
        // // by using include_front=false
        // // start recording the product in temp_2
        // if (!include_front) {
        // temp_2 = temp_2 * nums[i];
        // }
        // temp_1 = temp_1 * nums[i];

        // // if include_front == true, means no negative number in previous elemtents
        // // temp_2 is never called
        // // max = temp_1 if temp_1>max
        // if (include_front && temp_1 > max){
        // max = temp_1;
        // } else if (!include_front) {
        // // if include_front == false, means there is negative number in previous
        // elemtents
        // // temp_2 is called
        // // max will be the larger one in temp_1 and temp_2
        // if (temp_1 > max) {
        // max = temp_1;
        // }
        // if (temp_2 > max) {
        // max = temp_2;
        // }
        // }

        // // flip include_front in last step in each loop
        // // so that no other steps related to include_front will be executed
        // // then include_front in each loop will relect whether the previous elements
        // include negative ones
        // if (nums[i] < 0) {
        // include_front = false;
        // }
        // }
        return max;
    }

    public static void main(String[] args) {
        int[] test_case_1 = { 2, -5, -2, -4, 3 };
        int[] test_case_2 = { -2, 0, -1 };
        Q152 mP = new Q152();
        System.out.println("case 1: " + mP.maxProduct(test_case_1));
        System.out.println("case 2: " + mP.maxProduct(test_case_2));
    }
}
