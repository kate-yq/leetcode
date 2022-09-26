public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums .length];
        // first make each position be the product of nums[0]to nums[i-1]
        int pre = 1;
        for (int i=0; i<nums.length; i++){
            products[i] = pre;
            pre = pre * nums[i];
        }
        // then time each position by the product of nums[i+1]to nums[length-1]
        int post =1;
        for (int j=nums.length-1; j>=0; j--){
            products[j] = products[j] * post;
            post = post * nums[j];
        }
        return products;
    }

    public static void main(String[] args){
        int[] test_case = {1, 2, 3, 4};
        Q238 pES = new Q238();
        for (int p: pES.productExceptSelf(test_case)){
            System.out.print(p + ", ");
        }
    }
}
