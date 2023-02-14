import java.util.PriorityQueue;

public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(
            (a, b) -> {return b-a;}
        );
        for (int stone : stones){
            maxheap.add(stone);
        }
        while (!maxheap.isEmpty()){
            int a = maxheap.poll();
            if (maxheap.isEmpty()){
                return a;
            }
            int b = maxheap.poll();
            if(a != b){
                maxheap.add(Math.abs(a-b));
            }
        }
        return 0;
    }
}
