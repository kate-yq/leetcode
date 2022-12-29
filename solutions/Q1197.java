import java.util.HashMap;

public class Q1197 {
    HashMap<int[], Integer> memo = new HashMap<>();

    public int minKnightMoves(int x, int y) {
        return findMoves(Math.abs(x), Math.abs(y));
    }

    private int findMoves(int x, int y){
        int[] key = {x, y};
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        if (x + y == 0){
            return 0;
        } else if (x + y == 1){
            return 3;
        } else if (x + y == 2){
            return 2;
        } else {
            int move = Math.min(findMoves(Math.abs(x-1), Math.abs(y-2)),
                findMoves(Math.abs(x-2), Math.abs(y-1))) + 1;
            memo.put(key, move);
            return move;
        }
    }
}
