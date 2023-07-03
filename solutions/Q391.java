import java.util.*;

public class Q391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int area = 0;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        HashSet<String> points = new HashSet<>();

        for (int[] rec : rectangles) {
            x1 = Math.min(x1, rec[0]);
            y1 = Math.min(y1, rec[1]);
            x2 = Math.max(x2, rec[2]);
            y2 = Math.max(y2, rec[3]);

            area += (rec[3] - rec[1]) * (rec[2] - rec[0]);
            String p1 = rec[0] + "," + rec[1];
            String p2 = rec[0] + "," + rec[3];
            String p3 = rec[2] + "," + rec[1];
            String p4 = rec[2] + "," + rec[3];
            for (String p : Arrays.asList(p1, p2, p3, p4)) {
                if (points.contains(p)) {
                    points.remove(p);
                } else {
                    points.add(p);
                }
            }
        }

        if (area != (y2 - y1) * (x2 - x1)) {
            return false;
        }

        if (points.size() != 4) {
            return false;
        }

        String p1 = x1 + "," + y1;
        String p2 = x1 + "," + y2;
        String p3 = x2 + "," + y1;
        String p4 = x2 + "," + y2;
        for (String p : Arrays.asList(p1, p2, p3, p4)) {
            if (!points.contains(p)) {
                return false;
            }
        }

        return true;
    }
}
