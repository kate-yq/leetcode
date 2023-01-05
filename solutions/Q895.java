import java.util.Stack;
import java.util.HashMap;

public class Q895 {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxfreq;

    public Q895() {
        this.freq = new HashMap<>();
        this.group = new HashMap<>();
        this.maxfreq = 0;
    }

    public void push(int val) {
        if (!freq.containsKey(val)){
            freq.put(val, 1);
        } else {
            freq.put(val, freq.get(val)+1);
        }
        int f = freq.get(val);
        if (f > maxfreq){
            maxfreq = f;
        }
        if (!group.containsKey(f)){
            group.put(f, new Stack<>());
        }
        group.get(f).push(val);
    }

    public int pop() {
        int val = group.get(maxfreq).pop();
        freq.put(val, freq.get(val) - 1);

        if (group.get(maxfreq).size() == 0){
            maxfreq--;
        }
        return val;
    }
}
