public class Q2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int[] count = new int[3];
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                count[0]++;
            } else if (c == 'R') {
                count[1]++;
            } else {
                count[2]++;
            }
        }

        return count[2] + Math.abs(count[0] - count[1]);
    }
}
