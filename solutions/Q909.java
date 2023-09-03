import java.util.*;

class Q909 {
    int n;

    public int snakesAndLadders(int[][] board) {
        this.n = board.length;

        int[] memo = new int[n * n + 1];
        Arrays.fill(memo, n * n + 1);
        memo[1] = 0;

        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int curStep = memo[cur];
                for (int j = cur + 1; j <= cur + 6 && j <= n * n; j++) {
                    int[] nextPo = getRowCol(j);
                    int next = board[nextPo[0]][nextPo[1]];
                    if (next == -1) {
                        next = j;
                    }
                    if (memo[next] > curStep + 1) {
                        memo[next] = curStep + 1;
                        q.add(next);
                    }
                }
            }
        }

        return memo[n * n] == n * n + 1 ? -1 : memo[n * n];
    }

    private int[] getRowCol(int num) {
        int[] ans = new int[2];
        int round = (num - 1) / n / 2;
        int remain = (num - 1) % (n * 2);
        ans[0] = n - 1 - round * 2 - remain / n;
        if (remain >= n) {
            ans[1] = n - 1 - (remain - n);
        } else {
            ans[1] = remain;
        }
        return ans;
    }
}