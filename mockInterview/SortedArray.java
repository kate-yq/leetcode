import java.util.*;

public class SortedArray {
    public int numOperations(List<Integer> nums){
        int ans = 0;
        List<Integer> afterInsert = new ArrayList<>();
        for (int i : nums){
            ans += insert(i, afterInsert);
        }
        return ans;
    }

    private int insert(int cur, List<Integer> afterInsert){
        if (afterInsert.size() == 0){
            afterInsert.add(cur);
            return 1;
        }
        int left = 0;
        int right = afterInsert.size()-1;
        while(left < right-1){
            int mid = left + (right-left)/2;
            if (afterInsert.get(mid)<cur){
                left = mid;
            } else if (afterInsert.get(mid) > cur){
                right = mid;
            } else {
                left = cur;
                right = cur;
            }
        }
        while(left>=0 && afterInsert.get(left)>=cur){
            left--;
        }
        while(right<afterInsert.size() && afterInsert.get(right)<=cur){
            right++;
        }
        int opL = left+1;
        int opR = afterInsert.size()-right;
        if (opL <= opR){
            afterInsert.add(left+1, cur);
            return opL * 2 + 1;
        } else {
            afterInsert.add(right, cur);
            return opR * 2 + 1;
        }
    }

    public static void main(String[] args){
        SortedArray sa = new SortedArray();
        List<Integer> test1 = new ArrayList<>(Arrays.asList(2,4,1,5,3));
        System.out.println(sa.numOperations(test1));
    }
}
