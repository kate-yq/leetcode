public class MinMaxArray {
    public int minimumMaxElement(int[] arr){
    // idea is that you can keep shift value from right to left, but not left to right,
    // this means you should minimize your left most node, s.t. the maximum of the array is minimized
    // a.k.a your left most node should always be the maximum
        int n = arr.length;
        int available_sink = 0;
        int current_max = arr[0];
        for (int i =0; i<n; i++){
            if (arr[i] <= current_max){
                available_sink += current_max - arr[i];
            } else {
                int diff = arr[i] - current_max;
                if(diff <= available_sink){
                    available_sink -= diff;
                } else {
                    // we yield, we need to distributed the remain across all members
                    int remain = diff - available_sink;
                    current_max += remain/(i+1);
                    if (remain % (i+1) >0){
                        current_max++;
                    }
                    available_sink = (remain % (i+1) == 0)? 0 : (i+1) - remain % (i+1);
                }
            }
        }
        return current_max;
    }

    public static void main(String[] args){
        int[] test1 = {3,9,5,9};
        int[] test2 = {7,9,3,5};
        MinMaxArray mm = new MinMaxArray();
        System.out.println(mm.minimumMaxElement(test1));
        System.out.println(mm.minimumMaxElement(test2));
    }
}
