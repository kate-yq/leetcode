public class Q739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] days = new int[n];

        // record the hottest day so that we know if there is an answer
        int hottest = temperatures[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] >= hottest) {
                hottest = temperatures[i];
            } else {
                int index = i + 1;
                while (temperatures[index] <= temperatures[i]) {
                    index = index + days[index];
                }
                days[i] = index - i;
            }
        }
        return days;
    }
}
