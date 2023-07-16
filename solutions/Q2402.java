import java.util.*;

class Q2402 {
    public int mostBooked(int n, int[][] meetings) {
        int[] usedTimes = new int[n];
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            emptyRooms.add(i);
        }

        // int[]{endtime, roomNo.}
        PriorityQueue<int[]> usingRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int[] meeting : meetings) {
            if (usingRooms.isEmpty()) {
                // no meeting
                int curRoom = emptyRooms.poll();
                usingRooms.add(new int[] { meeting[1], curRoom });
                usedTimes[curRoom]++;
            } else {
                // pop all meeting ends before this one
                while (!usingRooms.isEmpty() && usingRooms.peek()[0] <= meeting[0]) {
                    emptyRooms.add(usingRooms.poll()[1]);
                }
                if (emptyRooms.isEmpty()) {
                    // still no rooms available
                    int curEnd = usingRooms.peek()[0];
                    int curRoom = usingRooms.poll()[1];
                    usingRooms.add(new int[] { meeting[1] - meeting[0] + curEnd, curRoom });
                    usedTimes[curRoom]++;
                } else {
                    // has room available
                    int cur = emptyRooms.poll();
                    usingRooms.add(new int[] { meeting[1], cur });
                    usedTimes[cur]++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (usedTimes[i] > usedTimes[max]) {
                max = i;
            }
        }
        return max;
    }
}