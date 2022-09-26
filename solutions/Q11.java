public class Q11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int product = 0;

        while (left < right) {
            int temp;
            if (height[left] < height[right]) {
                temp = height[left] * (right - left);
                left = left + 1;
            } else if (height[left] > height[right]) {
                temp = height[right] * (right - left);
                right = right - 1;
            } else {
                temp = height[left] * (right - left);
                left = left + 1;
                right = right - 1;
            }
            if (temp > product) {
                product = temp;
            }
        }

        return product;
    }

    public static void main(String[] args) {
        int[] test_case = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        Q11 mA = new Q11();
        System.out.println("exp 49: " + mA.maxArea(test_case));
    }
}
