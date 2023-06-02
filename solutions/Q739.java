import java.util.*;;

public class Q739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] days = new int[n];

        Stack<Integer> monostack = new Stack<>();
        for (int i=n-1; i>=0; i--){
            while (!monostack.isEmpty() && temperatures[monostack.peek()] <= temperatures[i]){
                monostack.pop();
            }

            if (monostack.isEmpty()){
                days[i] = 0;
            } else {
                days[i] = monostack.peek() - i;
            }
            monostack.push(i);
        }

        return days;

    }
}
