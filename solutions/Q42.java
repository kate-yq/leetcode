public class Q42 {
    public int trap(int[] height) {
        if (height.length == 1){
            return 0;
        }

        // use 2 pointer to screen from both sides
        // move the pointer with less height
        // use 2 separate int to record current max height

        int left = 0;
        int right = height.length-1;
        int max_left = 0;
        int max_right = 0;
        int water = 0;

        while (left< right){
            if (height[left]<height[right]){
                if (height[left]>max_left){
                    max_left = height[left];
                } else {
                    water = water + max_left - height[left];
                }
                left++;
            } else {
                if (height[right]>max_right){
                    max_right = height[right];
                } else {
                    water = water + max_right - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] test_case_1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] test_case_2 = {4,2,0,3,2,5};
        Q42 tP = new Q42();
        System.out.println(("exp 6: " + tP.trap(test_case_1)));
        System.out.println("exp 9: " + tP.trap(test_case_2));
    }
}
