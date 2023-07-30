class Q1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (n > Math.ceil(hour)) {
            return -1;
        }

        int sumDis = 0;
        int right = (int) Math.ceil(dist[n - 1] / (hour - Math.floor(hour)));
        for (int d : dist) {
            sumDis += d;
            right = Math.max(right, d);
        }

        int left = Math.max((int) Math.floor(sumDis / hour), 1);

        while (left < right) {
            int mid = left + (right - left) / 2;
            double cost = 0;
            for (int i = 0; i < n - 1; i++) {
                cost += dist[i] / mid;
                if (dist[i] % mid > 0) {
                    cost++;
                }
                if (cost > hour) {
                    break;
                }
            }

            cost += dist[n - 1] / (double) mid;
            if (cost <= hour) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}