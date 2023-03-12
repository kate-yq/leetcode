import java.util.Arrays;

public class Q2589 {
    public int findMinimumTime(int[][] tasks) {
        // sort accroding to end time
        Arrays.sort(tasks, (a,b)->a[1]-b[1]);
        // max end time is 2000
        // so create an arr representing each unit time 
        boolean[] on = new boolean[2001];
        int ans = 0;

        for (int[] task : tasks){
            for (int i=task[0]; i<=task[1]; i++){
                if (on[i]){
                    // if the computer is on at current unit time
                    // a unit time could be deducted from total duration
                    task[2]--;
                } else if (task[2]>0 && task[1]-i+1==task[2]){
                    // if the computer is not on at current unit time
                    // and at the same time, there is not enough time to do the remaining task
                    // if current is not on
                    // turn on the computer and add 1 unit time to ans
                    // deduct 1 unit time from total duration
                    on[i] = true;
                    ans++;
                    task[2]--;
                }
            }
        }
        return ans;
    }
}
