import java.util.*;

public class Q855 {
    HashMap<Integer, int[]> start = new HashMap<>();
    HashMap<Integer, int[]> end = new HashMap<>();
    TreeSet<int[]> intervals;
    int N;

    public Q855(int n) {
        this.N = n;
        this.intervals = new TreeSet<>((a, b) -> {
            if (distance(a) == distance(b)) {
                return a[0] - b[0];
            }
            return distance(b) - distance(a);
        });

        addInterval(new int[] { -1, n });
    }

    private int distance(int[] interval) {
        if (interval[0] == -1) {
            return interval[1];
        }
        if (interval[1] == N) {
            return N - interval[0] - 1;
        }
        return (interval[1] - interval[0]) / 2;
    }

    private void addInterval(int[] interval) {
        start.put(interval[0], interval);
        end.put(interval[1], interval);
        intervals.add(interval);
    }

    private void removeInterval(int[] interval) {
        start.remove(interval[0]);
        end.remove(interval[1]);
        intervals.remove(interval);
    }

    public int seat() {
        int[] longest = intervals.first();
        int seat = 0;

        if (longest[0] == -1) {
            seat = 0;
        } else if (longest[1] == N) {
            seat = N - 1;
        } else {
            seat = longest[0] + (longest[1] - longest[0]) / 2;
        }
        removeInterval(longest);
        addInterval(new int[] { longest[0], seat });
        addInterval(new int[] { seat, longest[1] });

        return seat;
    }

    public void leave(int p) {
        int left = end.get(p)[0];
        int right = start.get(p)[1];

        removeInterval(new int[] { left, p });
        removeInterval(new int[] { p, right });
        addInterval(new int[] { left, right });
    }
}
