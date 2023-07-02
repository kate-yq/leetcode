import java.util.*;

public class Q969 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length - 1);
        return ans;
    }

    private void sort(int[] arr, int n) {
        if (n == 0) {
            return;
        }

        int max = -1;
        int maxIn = -1;
        for (int i = 0; i <= n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIn = i;
            }
        }

        reverseTop(arr, maxIn);
        ans.add(maxIn + 1);
        reverseTop(arr, n);
        ans.add(n + 1);

        sort(arr, n - 1);
    }

    private void reverseTop(int[] arr, int top) {
        int i = 0;
        int j = top;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
