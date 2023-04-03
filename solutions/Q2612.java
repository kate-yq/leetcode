import java.util.*;

public class Q2612 {
    public static int[] minReverseOperations(int n, int p, int[] banned, int k) {

        int[] result = new int[n];
		// odd even index into 2 Set
        TreeSet<Integer>[] set = new TreeSet[2];
        set[0] = new TreeSet<>();
        set[1] = new TreeSet<>();

		for (int i = 0; i < n; ++i) {
			set[i % 2].add(i);
			result[i] = i == p ? 0 : -1;
		}

		// remove p and banned index
        set[p % 2].remove(p);
		for (int i : banned) {
			set[i % 2].remove(i);
		}

        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);

        while(!queue.isEmpty()){
            int x = queue.poll();
            int i = Math.abs(x - k + 1);
            Integer j = set[i % 2].ceiling(i);
            while (j!= null && j<n-Math.abs(n-x-k)){
                queue.add(j);
                result[j] = result[x] + 1;
                set[i % 2].remove(j);
                j = set[i % 2].higher(j);
            }
        }

		return result;


        // TLE - basic idea: BFS

        // int[] ans = new int[n];
        // Arrays.fill(ans, Integer.MAX_VALUE);

        // ans[p] = 0;
        // for (int i: banned){
        //     ans[i] = -1;
        // }

        // int g = k%2 + 1;
        // HashSet<Integer> gaps = new HashSet<>();
        // while (g < k && g <= n){
        //     gaps.add(g);
        //     g += 2;
        // }

        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(p);

        // while (!queue.isEmpty()){
        //     int index = queue.poll();
            
        //     for (int gap : gaps){
        //         if (index + (k-gap-1)/2 - (k-1) >= 0 && index + (k-gap-1)/2 <n && ans[index-gap] == Integer.MAX_VALUE){
        //             ans[index - gap] = ans[index]+1;
        //             queue.add(index - gap);
        //         }
        //         if (index - (k-gap-1)/2 + (k-1) < n && index - (k-gap-1)/2 >=0 && ans[index+gap] == Integer.MAX_VALUE){
        //             ans[index+gap] = ans[index]+1;
        //             queue.add(index + gap);
        //         }
        //     }
        // }

        // for (int i=0; i<n; i++){
        //     if (ans[i] == Integer.MAX_VALUE){
        //         ans[i] = -1;
        //     }
        // }
        // return ans;
    }

    public static void main(String[] args){
        int[]as = Q2612.minReverseOperations(4, 0, new int[]{}, 4);
        for (int a : as){
            System.out.println(a);
        }
    }
}
