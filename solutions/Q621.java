import java.util.Arrays;
// import java.util.HashMap;
// import java.util.PriorityQueue;
// import java.util.Queue;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        // this is the model answer
        // by calculating the idle time, + tasks.length, will get the total length

        if (n == 0) {
            return tasks.length;
        }
        // use a len-26 array to record each task's frequece
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(freq);
        int idle = (freq[25] - 1) * n;

        // deduct the idle time if there is available tasks
        // but maximum deductible will be freq[25]-1
        for (int j = 24; j >= 0; j--) {
            idle = idle - Math.min(freq[j], freq[25] - 1);
        }
        // idle has to >=0
        return tasks.length + Math.max(idle, 0);

        // the followings is my original answer
        // can generate a sequence, rather than just the answer

        // // corner case
        // if (n == 0){
        // return tasks.length;
        // }

        // HashMap<Character, Integer> freq = new HashMap<>();
        // for (int i=0; i<tasks.length; i++){
        // if(freq.containsKey(tasks[i])){
        // freq.put(tasks[i], freq.get(tasks[i])+1);
        // } else {
        // freq.put(tasks[i], 1);
        // }
        // }
        // // create a max heap to pop the most frequent task at each round
        // Queue<Character> heap = new PriorityQueue<>(
        // (e1, e2) -> freq.get(e2)-freq.get(e1)
        // );
        // for (char c:freq.keySet()){
        // heap.add(c);
        // }
        // // to record each round of n+1, the task done
        // char[] temp_tasks = new char[n+1];

        // int len = 0;
        // while (!heap.isEmpty()){
        // Arrays.fill(temp_tasks, ' ');
        // for (int j=0; j<n+1; j++){
        // if (!heap.isEmpty()){
        // temp_tasks[j] = heap.poll();
        // }
        // }
        // len = len + n + 1;
        // for (int j=0; j<n+1 && freq.containsKey(temp_tasks[j]); j++){
        // if (freq.get(temp_tasks[j])>1){
        // freq.put(temp_tasks[j], freq.get(temp_tasks[j])-1);
        // heap.add(temp_tasks[j]);
        // }
        // }
        // }
        // for (int k=n; k>=0; k--){
        // if (temp_tasks[k]==' '){
        // len--;
        // }
        // }
        // return len;
    }

    public static void main(String[] args) {
        char[] test_case_1 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        char[] test_case_2 = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        Q621 lI = new Q621();
        System.out.println("exp: 6: " + lI.leastInterval(test_case_1, 0));
        System.out.println("exp: 8: " + lI.leastInterval(test_case_1, 2));
        System.out.println("exp: 16: " + lI.leastInterval(test_case_2, 2));
    }
}
